package lp.leilao.services.vehicles;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.VehicleUpdateDTO;
import lp.leilao.dtos.converter.AuctionMapper;
import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.dtos.vehicles.VehicleDTO;
import lp.leilao.entities.Auction;
import lp.leilao.entities.Vehicle;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.enums.CategoryEnums;
import lp.leilao.enums.VehicleTypesEnum;
import lp.leilao.exceptions.*;
import lp.leilao.repositories.VehicleRepository;
import lp.leilao.services.AuctionService;

import java.util.List;

@Singleton
public class VehicleService {
    private final AuctionService auctionService;
    private final VehicleRepository vehicleRepository;

    private AuctionMapper mapper = new AuctionMapperImpl();

    @Inject
    public VehicleService(AuctionService auctionService, VehicleRepository vehicleRepository) {
        this.auctionService = auctionService;
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDTO> getAllVehicles() {
            List<Vehicle> vehicles = vehicleRepository.findAll();
            if (vehicles.isEmpty()){
                throw new NoResultsFound();
            }
            return mapper.vehicleMapperToDTOList(vehicles);
    }

    public VehicleDTO getVehicleById(Long id) {
            Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(NoResultsFound::new);
            return mapper.vehicleMapperToDTO(vehicle);
    }

    public List<VehicleDTO> findVehicleByType(String category){
            String validCategory = typeVerification(category);
            List<Vehicle> vehicles = vehicleRepository.findByCategory(validCategory);
            if (vehicles.isEmpty()){
                throw new NoResultsFound();
            }
            return mapper.vehicleMapperToDTOList(vehicles);
    }

    public void createVehicle(VehicleUpdateDTO vehicle) {

        Auction auction = auctionService.getAuctionByProdId(vehicle.getProductId());
        if (!auction.getStatus().equals(AuctionStatusEnum.OPEN.status)) {
            throw new InvalidStatusFromRegister();
        }

        if (!auction.getCategory().equalsIgnoreCase(vehicle.getCategory())
                & !auction.getCategory().equalsIgnoreCase(CategoryEnums.BOTH.status)){
            throw new InvalidCategoryException();
        }

        vehicleRepository.save(mapper.vehicleUpdateToEntity(vehicle));
    }

    public void updateVehicle(Long id, VehicleUpdateDTO updateVehicle){
            Vehicle vehicle = vehicleRepository
                    .findById(id).orElseThrow(NoResultsFound::new);

            vehicle = updateMapper(vehicle, updateVehicle);

            vehicleRepository.update(vehicle);
    }

    public void deleteVehicle(Long id) {
        try{
            vehicleRepository.deleteById(id);
        }catch (FailDeleteException e){
            throw new FailDeleteException() ;
        }
    }

    private Vehicle updateMapper(Vehicle vehicle, VehicleUpdateDTO updateVehicle) {
        vehicle.setType(updateVehicle.getType() != null ?  typeVerification(updateVehicle.getType()) : vehicle.getType());
        vehicle.setInitialValue(updateVehicle.getInitialValue() != null ? updateVehicle.getInitialValue() : vehicle.getInitialValue());
        vehicle.getProduct().setId(updateVehicle.getProductId() != null ? updateVehicle.getProductId() : vehicle.getProduct().getId());
        vehicle.setColor(updateVehicle.getColor() != null ? updateVehicle.getColor() : vehicle.getColor());
        vehicle.setModel(updateVehicle.getModel() != null ? updateVehicle.getModel() : vehicle.getModel());
        vehicle.setBrand(updateVehicle.getBrand() != null ? updateVehicle.getBrand() : vehicle.getBrand());
        vehicle.setYearLicensing(updateVehicle.getYearLicensing() != null ? updateVehicle.getYearLicensing() : vehicle.getYearLicensing());
        return vehicle;
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

    public void deleteVehicle(List<Vehicle> vehicles) {
        vehicleRepository.deleteAll(vehicles);
    }
}
