package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.FinancialInstitution;
import lp.leilao.services.FInstitutionService;

@Controller("/financialInstitution")
@Tag(name = "Financial Institutions")
public class FInstitutionController {

    @Inject
    private final FInstitutionService fiService;

    public FInstitutionController(FInstitutionService fiService) {
        this.fiService = fiService;
    }

    @Get("/list")
    public Iterable<FinancialInstitution> listFI() {
        return fiService.getAllFI();
    }

    @Get("/{fi_id}")
    public FinancialInstitution getFI(Long fi_id) {

        return fiService.getFIById(fi_id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public FinancialInstitution createFI(@Body @Valid FinancialInstitution financial) {
        return fiService.createFI(financial);
    }

    @Put("/{fi_id}")
    public HttpResponse<FinancialInstitution> updateFI(@PathVariable Long fi_id, @Body FinancialInstitution updatedFI) {
        FinancialInstitution updated = fiService.updateFI(fi_id, updatedFI);
        if (updated != null) {
            return HttpResponse.ok(updated);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{fi_id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteFI(Long fi_id) {
        fiService.deleteFI(fi_id);
    }
}
