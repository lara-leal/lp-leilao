package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Truck;
import lp.leilao.entities.UtilityVehicle;
import lp.leilao.repositories.TruckRepository;
import lp.leilao.repositories.UtilityVehicleRepository;

@Singleton
public class UtilityVehicleService {
    @Inject
    private final UtilityVehicleRepository utilityVehicleRepository;

    public UtilityVehicleService(UtilityVehicleRepository utilityVehicleRepository) {
        this.utilityVehicleRepository = utilityVehicleRepository;
    }

    public Iterable<UtilityVehicle> getAllUtilityVehicles() {
        return utilityVehicleRepository.findAll();
    }

    public UtilityVehicle getUtilityVehicleById(Long id) {
        return utilityVehicleRepository.findById(id).orElse(null);
    }

    public UtilityVehicle createUtilityVehicle(UtilityVehicle utilityVehicle) {
        return utilityVehicleRepository.save(utilityVehicle);
    }

    public void deleteUtilityVehicle(Long id) {
        utilityVehicleRepository.deleteById(id);
    }
}
