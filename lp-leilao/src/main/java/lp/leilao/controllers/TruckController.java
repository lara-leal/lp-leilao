package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.vehicles.Truck;
import lp.leilao.services.TruckService;


@Controller("/vehicles/trucks")
public class TruckController {
    @Inject
    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @Get("/list")
    public Iterable<Truck> listTrucks() {
        return truckService.getAllTrucks();
    }

    @Get("/{id}")
    public Truck getTrucks(Long id) {

        return truckService.getTruckById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Truck createTruck(@Body @Valid Truck truck) {
        return truckService.createTruck(truck);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteTruck(Long id) {
        truckService.deleteTruck(id);
    }
}
