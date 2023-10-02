package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.FinancialInstitution;
import lp.leilao.services.FInstitutionService;

@Controller("/financialInstitution")
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

    @Get("/{id}")
    public FinancialInstitution getFI(Long id) {

        return fiService.getFIById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public FinancialInstitution createFI(@Body @Valid FinancialInstitution financial) {
        return fiService.createFI(financial);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteFI(Long id) {
        fiService.deleteFI(id);
    }
}
