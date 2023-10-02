package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Auction;
import lp.leilao.services.AuctionService;

@Controller("/auctions")
public class AuctionController {

    @Inject
    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @Get("/list")
    public Iterable<Auction> listAuctions() {
        return auctionService.getAllAuctions();
    }

    @Get("/{id}")
    public Auction getAuction(Long id) {

        return auctionService.getAuctionById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Auction createAuction(@Body @Valid Auction auction) {
        return auctionService.createAuction(auction);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteAuction(Long id) {
        auctionService.deleteAuction(id);
    }

}
