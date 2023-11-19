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

    @Scheduled(fixedDelay = "30s")
    void executeEveryThirtySec() {

        List<Vehicle> vehiclesToTransfer = new ArrayList<>();
        List<ComputingDevice> devicesToTransfer = new ArrayList<>();

        List<Auction> auctions = auctionService.getAuctionByStatus(AuctionStatusEnum.FINISHED.status);
        if (auctions.isEmpty()){
            return;
        }
        Optional<Auction> auctionForRegisterProducts = getAuction("BOTH");

        if (auctionForRegisterProducts.isPresent()){
            for (Auction auction : auctions){
                vehiclesResult(auction, auctionForRegisterProducts, vehiclesToTransfer);
                devicesResult(auction, auctionForRegisterProducts, devicesToTransfer);
            }
        }else {
            Optional<Auction> vehicle = getAuction("VEHICLE");
            if (vehicle.isPresent()) {
                for (Auction auction : auctions) {
                    vehiclesResult(auction, vehicle, vehiclesToTransfer);
                }
            }
            Optional<Auction> device = getAuction("DEVICE");
            if (device.isPresent()){
                for (Auction auction : auctions){
                    devicesResult(auction, device, devicesToTransfer);
                }
            }

        }

        if (!vehiclesToTransfer.isEmpty()){
            vehicleService.updateVehicleForNewProduct(vehiclesToTransfer);
        }
        if (!devicesToTransfer.isEmpty()){
            computingDeviceService.updateDeviceForNewProduct(devicesToTransfer);
        }

    }

    private Optional<Auction> getAuction(String category) {
        Optional<Auction> auctionForRegisterProducts = auctionService.getAuctionByStatus(AuctionStatusEnum.OPEN.status)
                .stream().filter(auction -> auction.getCategory().equals(category)).findFirst();
        return auctionForRegisterProducts;
    }

    private static void devicesResult(Auction auction, Optional<Auction> auctionForRegisterProducts, List<ComputingDevice> devicesToTransfer) {
        auction.getProduct().getDevices().forEach(device -> {
            if (device.getBids().isEmpty()){
                device.setProduct(auctionForRegisterProducts.get().getProduct());
                devicesToTransfer.add(device);
            }
        });
    }

    private static void vehiclesResult(Auction auction, Optional<Auction> auctionForRegisterProducts,
                                       List<Vehicle> vehiclesToTransfer) {
        auction.getProduct().getVehicles().forEach(vehicle -> {
            if (vehicle.getBid().isEmpty()){
                vehicle.setProduct(auctionForRegisterProducts.get().getProduct());
                vehiclesToTransfer.add(vehicle);
            }
        });
    }
}
