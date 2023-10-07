package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Auction;
import lp.leilao.services.AuctionService;

@Controller("/auctions")
@Tag(name = "Auctions")
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

    @Get("/{auction_id}")
    public Auction getAuction(Long auction_id) {

        return auctionService.getAuctionById(auction_id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Auction createAuction(@Body @Valid Auction auction) {
        return auctionService.createAuction(auction);
    }

    @Put("/{auction_id}")
    public HttpResponse<Auction> updateAuction(@PathVariable Long auction_id, @Body Auction updatedAuction) {
        Auction updated = auctionService.updateAuction(auction_id, updatedAuction);
        if (updated != null) {
            return HttpResponse.ok(updated);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{auction_id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteAuction(Long auction_id) {
        auctionService.deleteAuction(auction_id);
    }

}
