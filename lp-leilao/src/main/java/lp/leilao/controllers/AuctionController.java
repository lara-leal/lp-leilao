package lp.leilao.controllers;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.AuctionDTO;
import lp.leilao.entities.Auction;
import lp.leilao.services.AuctionService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller("/auction")
@Tag(name = "Auctions")
public class AuctionController {

    private final AuctionService auctionService;

    @Inject
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @Get("/allAuctions")
    public List<AuctionDTO> listAuctions() {
        return auctionService.getAllAuctions();
    }

    @Get("all")
    public HttpResponse<List<AuctionDTO>> auction() {

        return HttpResponse.ok().body(auctionService.getAllAuctions());
    }

    @Get("/find-by-category")
    public HttpResponse<List<Auction>> getAuction(@Parameter String category) {
        List<Auction> auction = auctionService.getAuctionByType(category);
        return HttpResponse.ok(auction);
    }

    @Get("/export-data/{id}")
    public HttpResponse<?> auction(@PathVariable Long id) throws IOException {
        auctionService.exportDatFile(id);
        return HttpResponse.ok();
    }

    @Post("/create")
    public HttpResponse<?> createAuction(@Body @Valid Auction auction) {
        auctionService.createAuction(auction);
        return HttpResponse.created("Auction successfully created");
    }

    @Put("/{auction_id}")
    public HttpResponse<?> updateAuction(@PathVariable Long auction_id, @Body Auction updatedAuction) {
         auctionService.updateAuction(auction_id, updatedAuction);
         return HttpResponse.ok();
    }

    @Delete("/{auction_id}")
    public HttpResponse<?> deleteAuction(Long auction_id) {
        auctionService.deleteAuction(auction_id);
        return HttpResponse.ok("successful delete");
    }

}
