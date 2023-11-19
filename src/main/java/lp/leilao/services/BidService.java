package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.BidDTO;
import lp.leilao.dtos.BidUpdateDTO;
import lp.leilao.dtos.converter.AuctionMapper;
import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.entities.Bid;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.entities.Vehicle;
import lp.leilao.enums.BidCategoryEnum;
import lp.leilao.exceptions.CategoryNotValidException;
import lp.leilao.exceptions.InvalidBidException;
import lp.leilao.exceptions.NoResultsFound;
import lp.leilao.repositories.BidRepository;
import lp.leilao.services.devices.ComputingDeviceService;
import lp.leilao.services.vehicles.VehicleService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Singleton
public class BidService {

    private final BidRepository bidRepository;

    private final ClientService clientService;

    private final VehicleService vehicleService;

    private final ComputingDeviceService deviceService;

    private AuctionMapper mapper = new AuctionMapperImpl();

    @Inject
    public BidService(BidRepository bidRepository, ClientService clientService, VehicleService vehicleService, ComputingDeviceService deviceService) {
        this.bidRepository = bidRepository;
        this.clientService = clientService;
        this.vehicleService = vehicleService;
        this.deviceService = deviceService;
    }

    public List<BidDTO> findAllBids() {
        List<Bid> bid = bidRepository.findAll();

        if (bid.isEmpty()){
            throw new NoResultsFound();
        }

        return mapper.bidToDTOList(bid);
    }

    public BidDTO findBidById(Long id) {
        Bid bid = bidRepository.findById(id).orElseThrow(NoResultsFound::new);
        return mapper.bidToDTO(bid);
    }

    public void registerBid(BidDTO bid) {
        Bid bidSave = mapper.dtoToEntity(bid);
        bidSave.setClient(clientService.getClientByCpf(bid.getClient().getCpf()));

        validCategoryBid(bid.getBidCategory());
        if(bid.getBidCategory().equalsIgnoreCase("VEHICLE")
                && bid.getProductIdSale() != null){
            Vehicle vehicle = mapper.
                    vehicleDTOMapperEntity(vehicleService.getVehicleById(bid.getProductIdSale()));
            if(vehicle.getInitialValue() > bid.getBidValue()){
                throw new InvalidBidException();
            };
            vehicle.setId(bid.getProductIdSale());
            bidSave.setVehicle(vehicle);
            vehicle.setInitialValue(bid.getBidValue() + (bid.getBidValue() * 0.03));
            vehicleService.updateVehicle(vehicle.getId(),mapper.vehicleToDTOUpdate(vehicle));
        };

        if(bid.getBidCategory().equalsIgnoreCase("DEVICE")
                && bid.getProductIdSale() != null){
            ComputingDevice device = mapper.deviceDTOToEntity(deviceService.getDeviceById(bid.getProductIdSale()));
            if(device.getInitialValue() > bid.getBidValue()){
                throw new InvalidBidException();
            };
            device.setId(bid.getProductIdSale());
            bidSave.setDevice(device);
            device.setInitialValue(bid.getBidValue() + (bid.getBidValue() * 0.03));
            deviceService.updateDevice(device.getId(), mapper.deviceEntityToUpdateDTO(device));
        };

        bid.setDate(LocalDateTime.now());

        bidRepository.update(bidSave);
    }


    private String validCategoryBid(String bidCategory) {
        for (BidCategoryEnum category : BidCategoryEnum.values()){
            if (category.status.equalsIgnoreCase(bidCategory)){
                return category.status;
            }
        }
        throw new CategoryNotValidException();
    }


    public void updateBid(Long id, BidUpdateDTO updatedBid) {
        BidDTO bid = findBidById(id);
        bid = updateMapper(bid, updatedBid);

        bidRepository.update(mapper.dtoToEntity(bid));
    }

    public void updateBidWinner(Long id, Bid updatedBid) {
        Optional<Bid> bid = bidRepository.findById(id);
        if (bid.isPresent()){
            bid.get().setWinner(Boolean.TRUE);
            bidRepository.update(bid.get());
        }

    }
    private BidDTO updateMapper(BidDTO bid, BidUpdateDTO updatedBid) {
        bid.setBidValue(updatedBid.getBidValue() != null ? updatedBid.getBidValue() : bid.getBidValue());

        return bid;
    }

    public void deleteBid(Long id) {
        bidRepository.deleteById(id);
    }
}
