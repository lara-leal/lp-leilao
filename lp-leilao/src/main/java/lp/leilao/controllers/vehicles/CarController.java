package lp.leilao.controllers.vehicles;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.vehicles.CarDTO;
import lp.leilao.entities.vehicles.Car;
import lp.leilao.services.vehicles.CarService;

@Controller("/vehicles/cars")
@Tag(name = "Vehicle/Cars")
public class CarController {

    @Inject
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Get("/list")
    public Iterable<CarDTO> listCars() {
        return carService.getAllCars();
    }

    @Get("/{id}")
    public CarDTO getCars(Long id) {

        return carService.getCarById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public CarDTO createCar(@Body @Valid Car car) {
        return carService.createCar(car);
    }

    @Put("/{id}")
    public HttpResponse<CarDTO> updateCar(@PathVariable Long id, @Body CarDTO updatedCarDTO) {
        CarDTO updatedCar = carService.updateCar(id, updatedCarDTO);
        if (updatedCar != null) {
            return HttpResponse.ok(updatedCarDTO);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteCar(Long id) {
        carService.deleteCar(id);
    }
}
