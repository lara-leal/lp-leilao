package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Bid;
import lp.leilao.entities.Client;
import lp.leilao.enums.BidCategoryEnum;
import lp.leilao.exceptions.CategoryNotValidException;
import lp.leilao.exceptions.ClientException;
import lp.leilao.exceptions.NoResultsFound;
import lp.leilao.repositories.BidRepository;

import java.util.List;

@Singleton
public class BidService {

    private final BidRepository bidRepository;

    private final ClientService clientService;

    @Inject
    public BidService(BidRepository bidRepository, ClientService clientService) {
        this.bidRepository = bidRepository;
        this.clientService = clientService;
    }

    public List<Bid> findAllBids() {
        try{
            List<Bid> bid = bidRepository.findAll();

            if (bid.isEmpty()){
                throw new NoResultsFound();
            }

            return bid;
        }catch (RuntimeException e){
            throw new  NoResultsFound();
        }
    }

    public Bid findBidById(Long bid_id) {
        try {
            return bidRepository.findById(bid_id).orElseThrow(NoResultsFound::new);
        }catch (RuntimeException e){
            throw new NoResultsFound();
        }
    }

    public Bid registerBid(Bid bid) {
//        Client client = clientService.getClientByCpf(bid.getClient().getCpf());
//
//        bidRepository.save(bid);

        return bidRepository.save(bid);
    }


    private String validCategoryBid(String bidCategory) {
        for (BidCategoryEnum category : BidCategoryEnum.values()){
            if (category.status.equalsIgnoreCase(bidCategory)){
                return category.status;
            }
        }
        throw new CategoryNotValidException();
    }


    public void updateBid(Long id, Bid updatedBid) {
        try {
            Bid bid = findBidById(id);
            bid = updateMapper(bid, updatedBid);

            bidRepository.update(bid);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    private Bid updateMapper(Bid bid, Bid updatedBid) {
        bid.setBidValue(updatedBid.getBidValue() != null ? updatedBid.getBidValue() : bid.getBidValue());
        bid.setDevice(updatedBid.getDevice() != null ? updatedBid.getDevice() : bid.getDevice());
        bid.setVehicle(updatedBid.getVehicle() != null ? updatedBid.getVehicle() : bid.getVehicle());

        return bid;
    }

    public void deleteBid(Long id) {
        try {
            bidRepository.deleteById(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
