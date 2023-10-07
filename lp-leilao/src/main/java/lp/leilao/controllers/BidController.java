package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Bid;
import lp.leilao.services.BidService;

@Controller("/auction/bids")
@Tag(name = "Bids")
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

    @Get("/{bid_id}")
    public Bid getBids(Long bid_id) {

        return bidService.getBidById(bid_id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Bid createBid(@Body @Valid Bid bid) {
        return bidService.createBid(bid);
    }

    @Put("/{bid_id}")
    public HttpResponse<Bid> updateBid(@PathVariable Long bid_id, @Body Bid updatedBid) {
        Bid updated = bidService.updateBid(bid_id, updatedBid);
        if (updated != null) {
            return HttpResponse.ok(updated);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{bid_id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteBid(Long bid_id) {
        bidService.deleteBid(bid_id);
    }

}
