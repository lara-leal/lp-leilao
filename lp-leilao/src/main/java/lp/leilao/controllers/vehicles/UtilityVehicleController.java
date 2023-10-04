package lp.leilao.controllers.vehicles;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.vehicles.UtilityVehicleDTO;
import lp.leilao.entities.vehicles.UtilityVehicle;
import lp.leilao.services.vehicles.UtilityVehicleService;

@Controller("/vehicles/utility-vehicles")
public class UtilityVehicleController {
    @Inject
    private final UtilityVehicleService utilityVehicleService;

    public UtilityVehicleController(UtilityVehicleService utilityVehicleService) {
        this.utilityVehicleService = utilityVehicleService;
    }

    @Get("/list")
    public Iterable<UtilityVehicleDTO> listUtilityVehicles() {
        return utilityVehicleService.getAllUtilityVehicles();
    }

    @Get("/{id}")
    public UtilityVehicleDTO getUtilityVehicle(Long id) {

        return utilityVehicleService.getUtilityVehicleById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public UtilityVehicleDTO createUtilityVehicle(@Body @Valid UtilityVehicle utilityVehicle) {
        return utilityVehicleService.createUtilityVehicle(utilityVehicle);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteUtilityVehicle(Long id) {
        utilityVehicleService.deleteUtilityVehicle(id);
    }
}
