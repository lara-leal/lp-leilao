package lp.leilao.services.vehicles;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.vehicles.MotorcycleDTO;
import lp.leilao.entities.vehicles.Motorcycle;
import lp.leilao.repositories.vehicles.MotorcycleRepository;

import java.util.ArrayList;
import java.util.List;


@Singleton
public class MotorcycleService {
    @Inject
    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public Iterable<MotorcycleDTO> getAllMotorcycles() {
        return toMotorcycleDTOList(motorcycleRepository.findAll());
    }

    public MotorcycleDTO getMotorcycleById(Long id) {
        return motorcycleRepository.findById(id)
                .map(this::toMotorcycleDTO)
                .orElse(null);
    }

    public MotorcycleDTO createMotorcycle(Motorcycle motorcycle) {
        return toMotorcycleDTO(motorcycleRepository.save(motorcycle));
    }

    public void deleteMotorcycle(Long id) {
        motorcycleRepository.deleteById(id);
    }

    private MotorcycleDTO toMotorcycleDTO(Motorcycle motorcycle) {
        MotorcycleDTO dto = new MotorcycleDTO();
        dto.setYearLicensing(motorcycle.getYearLicensing());
        dto.setResultPrecautionaryExpertise(motorcycle.getResultPrecautionaryExpertise());
        dto.setFairingCondition(motorcycle.getFairingCondition());

        return dto;
    }

    private Iterable<MotorcycleDTO> toMotorcycleDTOList(Iterable<Motorcycle> motorcycles) {
        List<MotorcycleDTO> dtos = new ArrayList<>();
        for (Motorcycle motorcycle : motorcycles) {
            dtos.add(toMotorcycleDTO(motorcycle));
        }
        return dtos;
    }
}
