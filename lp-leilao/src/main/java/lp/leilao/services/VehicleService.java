package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Vehicle;
import lp.leilao.repositories.VehicleRepository;

@Singleton
public class VehicleService {
    @Inject
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public Iterable<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
