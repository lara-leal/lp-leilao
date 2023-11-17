package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Bid;
import lp.leilao.services.BidService;

import java.util.List;

@Controller("/auction/bids")
@Tag(name = "Bids")
public class BidController {

    private final BidService bidService;

    @Inject
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @Get("/available-bids")
    public HttpResponse<List<Bid>> allBinds() {
        return HttpResponse.ok().body(bidService.findAllBids());
    }

    @Get("/find-bid/{id}")
    public HttpResponse<Bid> findBidById(@PathVariable Long id) {

        return HttpResponse.ok().body(bidService.findBidById(id));
    }

    @Post("/register-bid")
    public HttpResponse createBid(@Body @Valid Bid bid) {
        bidService.registerBid(bid);
        return HttpResponse.created("Register with successfully");
    }

    @Put("/update-bid/{id}")
    public HttpResponse<?> updateBidById(@PathVariable Long bid_id, @Body Bid updatedBid) {
        bidService.updateBid(bid_id, updatedBid);
        return HttpResponse.ok("Update with successfully");
    }

    @Delete("/delete/{id}")
    public HttpResponse<?> deleteBid(Long bid_id) {
        bidService.deleteBid(bid_id);
        return HttpResponse.noContent().body("Delete with successfully");
    }

}
