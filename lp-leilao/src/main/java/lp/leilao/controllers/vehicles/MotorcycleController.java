package lp.leilao.controllers.vehicles;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.vehicles.Motorcycle;
import lp.leilao.dtos.vehicles.MotorcycleDTO;
import lp.leilao.services.vehicles.MotorcycleService;


@Controller("/vehicles/motorcycles")
public class MotorcycleController {
    @Inject
    private final MotorcycleService motorcycleService;

    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @Get("/list")
    public Iterable<MotorcycleDTO> listMotorcycles() {
        return motorcycleService.getAllMotorcycles();
    }

    @Get("/{id}")
    public MotorcycleDTO getMotorcycles(Long id) {

        return motorcycleService.getMotorcycleById(id);
    }


    @Post("/create")
    @Status(HttpStatus.CREATED)
    public MotorcycleDTO createMotorcycle(@Body @Valid Motorcycle motorcycle) {
        return motorcycleService.createMotorcycle(motorcycle);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteMotorcycle(Long id) {
        motorcycleService.deleteMotorcycle(id);
    }
}