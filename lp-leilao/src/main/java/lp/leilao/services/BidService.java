package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Bid;
import lp.leilao.repositories.BidRepository;
@Singleton
public class BidService {
    @Inject
    private final BidRepository bidRepository;

    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public Iterable<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    public Bid getBidById(Long bid_id) {
        return bidRepository.findById(bid_id).orElse(null);
    }

    public Bid createBid(Bid bid) {
        return bidRepository.save(bid);
    }

    public Bid updateBid(Long bid_id, Bid updatedBid) {
        Bid existingBid = bidRepository.findById(bid_id).orElse(null);
        if (existingBid != null) {
            existingBid.setBid_value(updatedBid.getBid_value());
            existingBid.setData(updatedBid.getData());

            return bidRepository.update(existingBid);
        }
        return null;
    }

    public void deleteBid(Long bid_id) {
        bidRepository.deleteById(bid_id);
    }
}
