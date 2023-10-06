package lp.leilao.services.vehicles;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.vehicles.CarDTO;
import lp.leilao.entities.vehicles.Car;
import lp.leilao.repositories.vehicles.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class CarService {
    @Inject
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Iterable<CarDTO> getAllCars() {
        return toCarDTOList(carRepository.findAll());
    }

    public CarDTO getCarById(Long id) {
        return carRepository.findById(id)
                .map(this::toCarDTO)
                .orElse(null);
    }

    public CarDTO createCar(Car car) {
        return toCarDTO(carRepository.save(car));
    }

    public Car updateCar(Long id, Car updatedCar) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setManufactureYear(updatedCar.getManufactureYear());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setDescription(updatedCar.getDescription());
            existingCar.setPrice(updatedCar.getPrice());
            existingCar.setColor(updatedCar.getColor());
            existingCar.setSunroof(updatedCar.getSunroof());
            existingCar.setYearLicensing(updatedCar.getYearLicensing());
            existingCar.setResultPrecautionaryExpertise(updatedCar.getResultPrecautionaryExpertise());

            return carRepository.update(existingCar);
        }
        return null;
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    private CarDTO toCarDTO(Car car) {
        CarDTO dto = new CarDTO();
        dto.setSunroof(car.getSunroof());
        dto.setYearLicensing(car.getYearLicensing());
        dto.setResultPrecautionaryExpertise(car.getResultPrecautionaryExpertise());
        return dto;
    }

    private Iterable<CarDTO> toCarDTOList(Iterable<Car> cars) {
        List<CarDTO> dtos = new ArrayList<>();
        for (Car car : cars) {
            dtos.add(toCarDTO(car));
        }
        return dtos;
    }

}
