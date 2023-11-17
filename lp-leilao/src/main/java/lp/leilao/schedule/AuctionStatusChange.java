package lp.leilao.schedule;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Auction;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.repositories.AuctionRepository;
import lp.leilao.services.AuctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class AuctionStatusChange {

    private final AuctionRepository auctionRepository;

    private final AuctionService auctionService;
    private static final Logger LOG = LoggerFactory.getLogger(AuctionStatusChange.class);

    @Inject
    public AuctionStatusChange(AuctionRepository auctionRepository, AuctionService auctionService) {
        this.auctionRepository = auctionRepository;
        this.auctionService = auctionService;
    }

//    @Scheduled(fixedDelay = "20s")
    void executeEveryFiveMin() {
        List<Auction> auctions = auctionRepository.findAll();
        List<Auction> statusUpdate = new ArrayList<>();
        for(Auction auction : auctions){
            Boolean changeStatus = auctionService.validDate(auction.getOccurrenceDate(), auction.getOccurrenceHour());
            if (!changeStatus){
                if (auction.getStatus().equalsIgnoreCase(AuctionStatusEnum.OPEN.status)){
                    auction.setStatus(AuctionStatusEnum.IN_PROGRESS.status);
                    statusUpdate.add(auction);
                    LOG.info("Update opens auctions");
                }
            }
            if (auction.getStatus().equalsIgnoreCase(AuctionStatusEnum.IN_PROGRESS.status)){
                if ((auction.getFinishDate().isBefore(LocalDate.now()) | auction.getFinishDate().isEqual(LocalDate.now()))
                        && auction.getFinishHour().isBefore(LocalTime.now())){
                    auction.setStatus(AuctionStatusEnum.FINISHED.status);
                    LOG.info("Update in progress auctions");
                    statusUpdate.add(auction);
                }
            }
        }

        auctionService.updateAuctionStatus(statusUpdate);
    }
}
