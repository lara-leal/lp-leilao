package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Motorcycle;
import lp.leilao.repositories.MotorcycleRepository;


@Singleton
public class MotorcycleService {
    @Inject
    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public Iterable<Motorcycle> getAllMotorcycles() {
        return motorcycleRepository.findAll();
    }

    public Motorcycle getMotorcycleById(Long id) {
        return motorcycleRepository.findById(id).orElse(null);
    }

    public Motorcycle createMotorcycle(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    public void deleteMotorcycle(Long id) {
        motorcycleRepository.deleteById(id);
    }
}
