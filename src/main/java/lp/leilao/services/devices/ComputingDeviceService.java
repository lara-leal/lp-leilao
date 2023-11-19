package lp.leilao.services.devices;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Inject;
import lp.leilao.dtos.ComputingDeviceUpdateDTO;
import lp.leilao.dtos.converter.AuctionMapper;
import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.dtos.devices.ComputingDeviceDTO;
import lp.leilao.entities.Auction;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.enums.CategoryEnums;
import lp.leilao.enums.DevicesTypeEnum;
import lp.leilao.exceptions.*;
import lp.leilao.repositories.ComputingDeviceRepository;
import lp.leilao.services.AuctionService;

import java.util.List;
import java.util.Optional;


public class ComputingDeviceService {

    private AuctionMapper mapper = new AuctionMapperImpl();

    private final AuctionService auctionService;


    private final ComputingDeviceRepository computingDeviceRepository;

    @Inject
    public ComputingDeviceService(AuctionService auctionService, ComputingDeviceRepository computingDeviceRepository) {
        this.auctionService = auctionService;
        this.computingDeviceRepository = computingDeviceRepository;
    }

    public void registerDevice(ComputingDeviceUpdateDTO deviceDTO) {
        Auction auction = auctionService.getAuctionByProdId(deviceDTO.getProductId());

        if (!auction.getStatus().equals(AuctionStatusEnum.OPEN.status)){
            throw new InvalidStatusFromRegister();
        }

        if (!auction.getCategory().equalsIgnoreCase(deviceDTO.getCategory())
                & !auction.getCategory().equalsIgnoreCase(CategoryEnums.BOTH.status)){
            throw new InvalidCategoryException();
        }

        typeVerification(deviceDTO.getType());
        computingDeviceRepository.save(mapper.deviceUpdateToEntity(deviceDTO));

    }

    private String typeVerification(String category) {
        for (DevicesTypeEnum type : DevicesTypeEnum.values()) {
            if (type.status.equalsIgnoreCase(category)){
                return type.status;
            }
        }

        throw new DeviceTypeNotValidException();
    }

    public ComputingDeviceDTO getDeviceById(Long id){
        @NonNull Optional<ComputingDevice> device = computingDeviceRepository.findById(id);
        if (device.isEmpty()){
            throw new NoResultsFound();
        }
        return mapper.deviceMapperToDTO(device.get());
    }

    public List<ComputingDeviceDTO> findDeviceByCategory(String category){
        String validCategory = typeVerification(category);
        List<ComputingDevice> devices = computingDeviceRepository.findByCategory(validCategory);
        if (devices.isEmpty()){
            throw new NoResultsFound();
        }
        return mapper.deviceMapperToDTOList(devices);
    }

    public List<ComputingDeviceDTO> findAllDevices(){
        List<ComputingDevice> devices = computingDeviceRepository.findAll();
        if (devices.isEmpty()){
            throw new NoResultsFound();
        }
        return mapper.deviceMapperToDTOList(devices);
    }

    public void updateDevice(Long id, ComputingDeviceUpdateDTO updateDevice){
        ComputingDevice computingDevice = computingDeviceRepository
                .findById(id).orElseThrow(NoResultsFound::new);

        computingDevice = updateMapper(computingDevice, updateDevice);

        computingDeviceRepository.update(computingDevice);
    }

    public void deleteDevice(Long id){
        try {
            computingDeviceRepository.deleteById(id);
        }catch (ImpossibleDeleteAuctionProductsRegisted e){
            throw new ImpossibleDeleteAuctionProductsRegisted();
        }
    }
    private ComputingDevice updateMapper(ComputingDevice device, ComputingDeviceUpdateDTO updateDevice) {
        device.setType(updateDevice.getType() != null ?  typeVerification(updateDevice.getType()) : device.getType());
        device.setInitialValue(updateDevice.getInitialValue() != null ? updateDevice.getInitialValue() : device.getInitialValue());
        device.getProduct().setId(updateDevice.getProductId() != null ? updateDevice.getProductId() : device.getProduct().getId());
        device.setQuantity(updateDevice.getQuantity() != null ? updateDevice.getQuantity() : device.getQuantity());
        device.setDescription(updateDevice.getDescription() != null ? updateDevice.getDescription() : device.getDescription());
        return device;
    }

    public void updateDeviceForNewProduct(List<ComputingDevice> devicesToTransfer) {
        computingDeviceRepository.updateAll(devicesToTransfer);
    }

    public void deleteAllDevice(List<ComputingDevice> devices) {
        computingDeviceRepository.deleteAll(devices);
    }
}
