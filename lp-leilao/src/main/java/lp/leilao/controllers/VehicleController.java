package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.vehicles.VehicleDTO;
import lp.leilao.entities.Vehicle;
import lp.leilao.services.vehicles.VehicleService;

import java.util.List;

@Controller("/vehicles")
@Tag(name = "Vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Inject
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Get("/available-vehicle")
    public HttpResponse<List<VehicleDTO>> findAllVehicle() {
        return HttpResponse.ok().body(vehicleService.getAllVehicles());
    }

    @Get("/find-vehicle/{id}")
    public HttpResponse<VehicleDTO> getVehicle(@PathVariable Long id) {
        return HttpResponse.ok().body(vehicleService.getVehicleById(id));
    }

    @Get("/find-vehicle-category/{category}")
    public MutableHttpResponse<List<VehicleDTO>> getVehicleByCategory(@PathVariable String category) {
        return HttpResponse.ok().body(vehicleService.findVehicleByCategory(category));
    }

    @Post("/register-vehicle")
    public HttpResponse<?> createVehicle(@Body @Valid Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
        return HttpResponse.created("Registered with successfully");
    }

    @Put("/update-vehicle/{id}")
    public HttpResponse<?> updateVehicle(Vehicle vehicle, @PathVariable Long id){
        vehicleService.updateVehicle(id, vehicle);
        return HttpResponse.ok("Update with successful");
    }

    @Delete("/delete-vehicle/{id}")
    public HttpResponse deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return HttpResponse.ok("Deleted with successful");
    }
}
