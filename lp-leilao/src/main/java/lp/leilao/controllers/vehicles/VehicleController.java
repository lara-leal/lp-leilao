package lp.leilao.controllers.vehicles;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.vehicles.Vehicle;
import lp.leilao.services.vehicles.VehicleService;

@Controller("/vehicles")
public class VehicleController {
    @Inject
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Get("/list")
    public Iterable<Vehicle> listVehicles() {
        return vehicleService.getAllVehicles();
    }

    @Get("/{id}")
    public Vehicle getVehicle(Long id) {

        return vehicleService.getVehicleById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Vehicle createVehicle(@Body @Valid Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteVehicle(Long id) {
        vehicleService.deleteVehicle(id);
    }
}
