package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Car;
import lp.leilao.services.CarService;


@Controller("/vehicles/cars")
public class CarController {

    @Inject
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Get("/list")
    public Iterable<Car> listCars() {
        return carService.getAllCars();
    }

    @Get("/{id}")
    public Car getCars(Long id) {

        return carService.getCarById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Car createCar(@Body @Valid Car car) {
        return carService.createCar(car);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteCar(Long id) {
        carService.deleteCar(id);
    }
}
