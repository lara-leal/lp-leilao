package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Auction;
import lp.leilao.repositories.AuctionRepository;

@Singleton
public class AuctionService {
    @Inject
    private final AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    public Iterable<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Auction getAuctionById(Long auction_id) {
        return auctionRepository.findById(auction_id).orElse(null);
    }

    public Auction createAuction(Auction auction) {
        return auctionRepository.save(auction);
    }

    public Auction updateAuction(Long auction_id, Auction updatedAuction) {
        Auction existingAuction = auctionRepository.findById(auction_id).orElse(null);
        if (existingAuction != null) {
            existingAuction.setNumAuction(updatedAuction.getNumAuction());
            existingAuction.setFinancialInstitution(updatedAuction.getFinancialInstitution());
            existingAuction.setAddress(updatedAuction.getAddress());
            existingAuction.setInitialDate(updatedAuction.getInitialDate());
            existingAuction.setFinalDate(updatedAuction.getFinalDate());


            return auctionRepository.update(existingAuction);
        }
        return null;
    }


    public void deleteAuction(Long auction_id) {
        auctionRepository.deleteById(auction_id);
    }
}
