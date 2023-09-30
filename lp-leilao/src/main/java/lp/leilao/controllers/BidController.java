package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Bid;
import lp.leilao.services.BidService;

@Controller("/auction/bids")
public class BidController {
    @Inject
    private final BidService bidService;

    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @Get("/list")
    public Iterable<Bid> listBids() {
        return bidService.getAllBids();
    }

    @Get("/{id}")
    public Bid getBids(Long id) {

        return bidService.getBidById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Bid createBid(@Body @Valid Bid bid) {
        return bidService.createBid(bid);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteCar(Long id) {
        bidService.deleteBid(id);
    }

}
