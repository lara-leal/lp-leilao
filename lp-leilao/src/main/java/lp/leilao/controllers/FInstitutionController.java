package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.FinancialInstitution;
import lp.leilao.services.FInstitutionService;

import java.util.List;

@Controller("/financialInstitution")
@Tag(name = "Financial Institutions")
public class FInstitutionController {

    private final FInstitutionService fInstitutionService;

    @Inject
    public FInstitutionController(FInstitutionService fInstitutionService) {
        this.fInstitutionService = fInstitutionService;
    }

    @Get("/financial-institution")
    public HttpResponse<List<FinancialInstitution>> findFinancialInstitution() {
        return HttpResponse.ok(fInstitutionService.getAllFI());
    }

    @Get("/{id}")
    public HttpResponse<FinancialInstitution> getFinancialInstitution(Long id) {
        return HttpResponse.ok(fInstitutionService.getFIById(id));
    }

    @Post("/register-fi")
    public HttpResponse<?> createFI(@Body @Valid FinancialInstitution financial) {
        fInstitutionService.createFI(financial);
        return HttpResponse.created("Register with successfully");
    }

    @Put("/{id}")
    public HttpResponse<?> updateFI(@PathVariable Long id, @Body FinancialInstitution updatedFI) {
        fInstitutionService.updateFI(id, updatedFI);
        return HttpResponse.noContent();
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteFI(Long id) {
        fInstitutionService.deleteFI(id);
        return HttpResponse.ok("Delete with successuful");
    }
}
