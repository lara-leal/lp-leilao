package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.UtilityVehicle;
import lp.leilao.services.UtilityVehicleService;

@Controller("/vehicles/utility-vehicles")
public class UtilityVehicleController {
    @Inject
    private final UtilityVehicleService utilityVehicleService;

    public UtilityVehicleController(UtilityVehicleService utilityVehicleService) {
        this.utilityVehicleService = utilityVehicleService;
    }

    @Get("/list")
    public Iterable<UtilityVehicle> listUtilityVehicles() {
        return utilityVehicleService.getAllUtilityVehicles();
    }

    @Get("/{id}")
    public UtilityVehicle getUtilityVehicle(Long id) {

        return utilityVehicleService.getUtilityVehicleById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public UtilityVehicle createUtilityVehicle(@Body @Valid UtilityVehicle utilityVehicle) {
        return utilityVehicleService.createUtilityVehicle(utilityVehicle);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteUtilityVehicle(Long id) {
        utilityVehicleService.deleteUtilityVehicle(id);
    }
}
