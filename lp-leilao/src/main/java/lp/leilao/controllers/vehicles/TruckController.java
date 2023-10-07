package lp.leilao.controllers.vehicles;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.vehicles.TruckDTO;
import lp.leilao.entities.vehicles.Truck;
import lp.leilao.services.vehicles.TruckService;


@Controller("/vehicles/trucks")
public class TruckController {
    @Inject
    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @Get("/list")
    public Iterable<TruckDTO> listTrucks() {
        return truckService.getAllTrucks();
    }

    @Get("/{id}")
    public TruckDTO getTrucks(Long id) {
        return truckService.getTruckById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public TruckDTO createTruck(@Body @Valid Truck truck) {
        return truckService.createTruck(truck);
    }
    @Put("/{id}")
    public HttpResponse<TruckDTO> updateTruck(@PathVariable Long id, @Body TruckDTO updatedTruckDTO) {
        TruckDTO updatedTruck = truckService.updateTruck(id, updatedTruckDTO);
        if (updatedTruck != null) {
            return HttpResponse.ok(updatedTruckDTO);
        } else {
            return HttpResponse.notFound();
        }
    }
    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteTruck(Long id) {
        truckService.deleteTruck(id);
    }
}
