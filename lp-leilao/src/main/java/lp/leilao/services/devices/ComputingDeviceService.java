package lp.leilao.services.devices;

import jakarta.inject.Inject;
import lp.leilao.dtos.devices.ComputingDeviceDTO;
import lp.leilao.entities.Auction;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.enums.CategoryEnums;
import lp.leilao.enums.DevicesTypeEnum;
import lp.leilao.exceptions.*;
import lp.leilao.repositories.ComputingDeviceRepository;
import lp.leilao.repositories.ProductRepository;
import lp.leilao.services.AuctionService;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;


public class ComputingDeviceService {

    private ModelMapper mapper = new ModelMapper();

    private final AuctionService auctionService;

    private final ProductRepository productRepository;

    private final ComputingDeviceRepository computingDeviceRepository;

    @Inject
    public ComputingDeviceService(AuctionService auctionService, ProductRepository productRepository, ComputingDeviceRepository computingDeviceRepository) {
        this.auctionService = auctionService;
        this.productRepository = productRepository;

        this.computingDeviceRepository = computingDeviceRepository;
    }

    public void registerDevice(ComputingDevice computingDevice) {
        try {
            String deviceType = typeVerification(computingDevice.getCategory());

            computingDevice.setCategory(deviceType);

            Auction auction = auctionService.getAuctionByProdId(computingDevice.getProduct().getId());
            if (!auction.getStatus().equals(AuctionStatusEnum.OPEN.status)){
                throw new InvalidStatusFromRegister();
            }

            if (!auction.getCategory().equalsIgnoreCase(computingDevice.getCategory())
                    & !auction.getCategory().equalsIgnoreCase(CategoryEnums.BOTH.status)){
                throw new InvalidCategoryException();
            }
            computingDeviceRepository.save(computingDevice);
        }catch (InvalidStatusFromRegister e){
            throw new RuntimeException();
        }
    }

    private String typeVerification(String category) {
        for (DevicesTypeEnum type : DevicesTypeEnum.values()) {
            if (type.status.equalsIgnoreCase(category)){
                return type.status;
            }
        }

        throw new DeviceTypeNotValidException();
    }


    public List<ComputingDeviceDTO> findDeviceByCategory(String category){
        try {
            String validCategory = typeVerification(category);
            List<ComputingDevice> devices = computingDeviceRepository.findByCategory(validCategory);
            if (devices.isEmpty()){
                throw new NoResultsFound();
            }
            return mapperDTO(devices);
        }catch (DeviceTypeNotValidException e){
            throw new RuntimeException();
        }
    }

    public List<ComputingDeviceDTO> findAllDevices(){
        try{
            List<ComputingDevice> devices = computingDeviceRepository.findAll();
            if (devices.isEmpty()){
                throw new NoResultsFound();
            }
            return mapperDTO(devices);
        }catch (NoResultsFound e){
            throw new RuntimeException();
        }
    }

    public void updateDevice(Long id, ComputingDevice updateDevice){
        try {
            ComputingDevice computingDevice = computingDeviceRepository
                    .findById(id).orElseThrow(NoResultsFound::new);

            computingDevice = updateMapper(computingDevice, updateDevice);

            computingDeviceRepository.save(computingDevice);

        }catch (NoResultsFound e){
            throw new RuntimeException();
        }
    }

    public void deleteDevice(Long id){
        try {
            computingDeviceRepository.deleteById(id);
        }catch (ImpossibleDeleteAuctionProductsRegisted e){
            throw new RuntimeException();
        }
    }

    private List<ComputingDeviceDTO> mapperDTO(List<ComputingDevice> devices) {
        List<ComputingDeviceDTO> deviceDTO = new ArrayList<>();
        devices.forEach(device -> deviceDTO.add(mapper.map(device, ComputingDeviceDTO.class)));
        return deviceDTO;
    }

    private ComputingDevice updateMapper(ComputingDevice device, ComputingDevice updateDevice) {
        device.setCategory(updateDevice.getCategory() != null ?  typeVerification(updateDevice.getCategory()) : device.getCategory());
        device.setInitialValue(updateDevice.getInitialValue() != null ? updateDevice.getInitialValue() : device.getInitialValue());
        device.setProduct(updateDevice.getProduct() != null ? updateDevice.getProduct() : device.getProduct());
        device.setQuantity(updateDevice.getQuantity() != null ? updateDevice.getQuantity() : device.getQuantity());
        device.setDescription(updateDevice.getDescription() != null ? updateDevice.getDescription() : device.getDescription());
        return device;
    }

}
