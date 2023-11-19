package lp.leilao.schedule;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.converter.AuctionMapper;
import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.entities.Auction;
import lp.leilao.entities.Bid;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.entities.Vehicle;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.repositories.AuctionRepository;
import lp.leilao.services.AuctionService;
import lp.leilao.services.BidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class AuctionStatusChange {

    private final AuctionRepository auctionRepository;

    private final AuctionService auctionService;

    private final BidService bidService;

    private AuctionMapper mapper = new AuctionMapperImpl();
    private static final Logger LOG = LoggerFactory.getLogger(AuctionStatusChange.class);

    @Inject
    public AuctionStatusChange(AuctionRepository auctionRepository, AuctionService auctionService, BidService bidService) {
        this.auctionRepository = auctionRepository;
        this.auctionService = auctionService;
        this.bidService = bidService;
    }

    @Scheduled(fixedDelay = "20s")
    void executeEveryThirtySec() {
        List<Auction> auctions = auctionRepository.findAll();
        List<Bid> winnerBid = new ArrayList<>();
        List<Auction> statusUpdate = new ArrayList<>();
        for(Auction auction : auctions){
            Boolean changeStatus = validDateForInProgress(auction.getOccurrenceDate(), auction.getFinishDate());
            if (changeStatus){
                if (auction.getStatus().equalsIgnoreCase(AuctionStatusEnum.OPEN.status)){
                    auction.setStatus(AuctionStatusEnum.IN_PROGRESS.status);
                    statusUpdate.add((auction));
                    LOG.info("Update opens auctions");
                }
            }
            if (auction.getStatus().equalsIgnoreCase(AuctionStatusEnum.IN_PROGRESS.status)){
                if (validDateForFinish(auction.getOccurrenceDate(), auction.getFinishDate())){
                    auction.setStatus(AuctionStatusEnum.FINISHED.status);
                    if (!auction.getProduct().getDevices().isEmpty()){
                        auction.getProduct().getDevices().forEach(device ->
                                device.getBids().stream().max(Comparator.comparingDouble(Bid::getBidValue)).get().setWinner(Boolean.TRUE));

                        for (ComputingDevice device : auction.getProduct().getDevices()){
                            winnerBid = device.getBids().stream().filter(bid -> bid.getWinner().equals(Boolean.TRUE)).collect(Collectors.toList());
                        }

                    }
                    if (!auction.getProduct().getVehicles().isEmpty()){
                        auction.getProduct().getVehicles().forEach(vehicle ->
                                vehicle.getBid().stream().max(Comparator.comparingDouble(Bid::getBidValue)).get().setWinner(Boolean.TRUE));

                        for (Vehicle vehicle : auction.getProduct().getVehicles()){
                            winnerBid = vehicle.getBid().stream().filter(bid -> bid.getWinner().equals(Boolean.TRUE)).collect(Collectors.toList());
                        }
                    }

                    LOG.info("Update in progress auctions");
                    statusUpdate.add((auction));
                }
            }
        }
        winnerBid.forEach(bid -> bidService.updateBidWinner(bid.getBidId() ,bid));

        auctionService.updateAuctionStatus(statusUpdate);
    }

    public Boolean validDateForInProgress(LocalDateTime occurrenceDate, LocalDateTime finishDate) {
        if (occurrenceDate.isBefore(LocalDateTime.now()) && finishDate.isAfter(LocalDateTime.now())){
            return true;
        }
        return false;
    }

    public Boolean validDateForFinish(LocalDateTime occurrenceDate, LocalDateTime finishDate) {
        if (occurrenceDate.isBefore(LocalDateTime.now()) && finishDate.isBefore(LocalDateTime.now())){
            return true;
        }
        return false;
    }
}
