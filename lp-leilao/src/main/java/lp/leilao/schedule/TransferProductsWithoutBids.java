package lp.leilao.schedule;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Auction;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.entities.Vehicle;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.services.AuctionService;
import lp.leilao.services.devices.ComputingDeviceService;
import lp.leilao.services.vehicles.VehicleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class TransferProductsWithoutBids {
    private final AuctionService auctionService;

    private final ComputingDeviceService computingDeviceService;

    private final VehicleService vehicleService;

    @Inject
    public TransferProductsWithoutBids(AuctionService auctionService, ComputingDeviceService computingDeviceService, VehicleService vehicleService) {
        this.auctionService = auctionService;
        this.computingDeviceService = computingDeviceService;
        this.vehicleService = vehicleService;
    }

//    @Scheduled(fixedDelay = "40s")
    void executeEveryFiveMin() {
        List<Auction> auctions = auctionService.getAuctionByStatus(AuctionStatusEnum.FINISHED.status);
        if (auctions.isEmpty()){
            return;
        }
        Optional<Auction> auctionForRegisterProducts = auctionService.getAuctionByStatus(AuctionStatusEnum.OPEN.status)
                .stream().findFirst();

        List<Vehicle> vehiclesToTransfer = new ArrayList<>();
        List<ComputingDevice> devicesToTransfer = new ArrayList<>();

        for (Auction auction : auctions){
            auction.getProduct().getVehicles().forEach(vehicle -> {
                if (vehicle.getBid().isEmpty()){
                    vehicle.setProduct(auctionForRegisterProducts.get().getProduct());
                    vehiclesToTransfer.add(vehicle);
                }
            });
            auction.getProduct().getDevices().forEach(device -> {
                if (device.getBids().isEmpty()){
                    device.setProduct(auctionForRegisterProducts.get().getProduct());
                    devicesToTransfer.add(device);
                }
            });
        }

        vehicleService.updateVehicleForNewProduct(vehiclesToTransfer);
        computingDeviceService.updateDeviceForNewProduct(devicesToTransfer);
    }
}
