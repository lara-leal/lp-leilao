package lp.leilao.services.vehicles;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.devices.ComputingDeviceDTO;
import lp.leilao.dtos.vehicles.VehicleDTO;
import lp.leilao.entities.Auction;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.entities.Product;
import lp.leilao.entities.Vehicle;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.enums.CategoryEnums;
import lp.leilao.enums.DevicesTypeEnum;
import lp.leilao.enums.VehicleTypesEnum;
import lp.leilao.exceptions.*;
import lp.leilao.repositories.VehicleRepository;
import lp.leilao.services.AuctionService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class VehicleService {
    private final AuctionService auctionService;
    private final VehicleRepository vehicleRepository;

    private ModelMapper mapper = new ModelMapper();

    @Inject
    public VehicleService(AuctionService auctionService, VehicleRepository vehicleRepository) {
        this.auctionService = auctionService;
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDTO> getAllVehicles() {
        try {
            List<Vehicle> vehicles = vehicleRepository.findAll();
            if (vehicles.isEmpty()){
                throw new NoResultsFound();
            }
            return mapperDTO(vehicles);
        }catch (RuntimeException e){
            throw new NoResultsFound();
        }
    }

    public VehicleDTO getVehicleById(Long id) {
        try {
            Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(NoResultsFound::new);
            return mapper.map(vehicle, VehicleDTO.class);
        } catch (NoResultsFound e) {
            throw new NoResultsFound();
        }
    }

    public List<VehicleDTO> findVehicleByCategory(String category){
        try {
            String validCategory = typeVerification(category);
            List<Vehicle> vehicles = vehicleRepository.findByCategory(validCategory);
            if (vehicles.isEmpty()){
                throw new NoResultsFound();
            }
            return mapperDTO(vehicles);
        }catch (DeviceTypeNotValidException e){
            throw new RuntimeException();
        }
    }

    public void createVehicle(Vehicle vehicle) {
        try{
            String vehicleType = typeVerification(vehicle.getCategory());

            vehicle.setCategory(vehicleType);

            Auction auction = auctionService.getAuctionByProdId(vehicle.getProduct().getId());
            if (!auction.getStatus().equals(AuctionStatusEnum.OPEN.status)) {
                throw new InvalidStatusFromRegister();
            }

            if (!auction.getCategory().equalsIgnoreCase(vehicle.getCategory())
                    & !auction.getCategory().equalsIgnoreCase(CategoryEnums.BOTH.status)){
                throw new InvalidCategoryException();
            }

            vehicleRepository.save(vehicle);
        }catch (NoAuctionFoundException e) {
            throw new RuntimeException();
        }
    }

    public void updateVehicle(Long id, Vehicle updateVehicle){
        try {
            Vehicle vehicle = vehicleRepository
                    .findById(id).orElseThrow(NoResultsFound::new);

            vehicle = updateMapper(vehicle, updateVehicle);

            vehicleRepository.save(vehicle);

        }catch (NoResultsFound e){
            throw new RuntimeException();
        }
    }

    public void deleteVehicle(Long id) {
        try{
            vehicleRepository.deleteById(id);
        }catch (FailDeleteException e){
            throw new RuntimeException() ;
        }
    }

    private Vehicle updateMapper(Vehicle vehicle, Vehicle updateVehicle) {
        vehicle.setCategory(updateVehicle.getCategory() != null ?  typeVerification(updateVehicle.getCategory()) : vehicle.getCategory());
        vehicle.setInitialValue(updateVehicle.getInitialValue() != null ? updateVehicle.getInitialValue() : vehicle.getInitialValue());
        vehicle.setProduct(updateVehicle.getProduct() != null ? updateVehicle.getProduct() : vehicle.getProduct());
        vehicle.setColor(updateVehicle.getColor() != null ? updateVehicle.getColor() : vehicle.getColor());
        vehicle.setModel(updateVehicle.getModel() != null ? updateVehicle.getModel() : vehicle.getModel());
        vehicle.setBrand(updateVehicle.getBrand() != null ? updateVehicle.getBrand() : vehicle.getBrand());
        vehicle.setYearLicensing(updateVehicle.getYearLicensing() != null ? updateVehicle.getYearLicensing() : vehicle.getYearLicensing());
        return vehicle;
    }

    private List<VehicleDTO> mapperDTO(List<Vehicle> vehicles) {
        List<VehicleDTO> vehicleDTO = new ArrayList<>();
        vehicles.forEach(vehicle -> vehicleDTO.add(mapper.map(vehicle, VehicleDTO.class)));
        return vehicleDTO;
    }

    private String typeVerification(String category) {
        for (VehicleTypesEnum type : VehicleTypesEnum.values()) {
            if (type.status.equalsIgnoreCase(category)){
                return type.status;
            }
        }

        throw new DeviceTypeNotValidException();
    }

    public void updateVehicleForNewProduct(List<Vehicle> vehiclesToTransfer) {
        vehicleRepository.updateAll(vehiclesToTransfer);
    }
}
