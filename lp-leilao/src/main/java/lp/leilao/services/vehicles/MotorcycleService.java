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

    public MotorcycleDTO updateMotorcycle(Long id, MotorcycleDTO updatedMotorcycleDTO) {
        Motorcycle existingMotorcycle = motorcycleRepository.findById(id).orElse(null);
        if (existingMotorcycle != null) {
            existingMotorcycle.setBrand(updatedMotorcycleDTO.getBrand());
            existingMotorcycle.setManufactureYear(updatedMotorcycleDTO.getManufactureYear());
            existingMotorcycle.setModel(updatedMotorcycleDTO.getModel());
            existingMotorcycle.setDescription(updatedMotorcycleDTO.getDescription());
            existingMotorcycle.setColor(updatedMotorcycleDTO.getColor());
            existingMotorcycle.setYearLicensing(updatedMotorcycleDTO.getYearLicensing());
            existingMotorcycle.setResultPrecautionaryExpertise(updatedMotorcycleDTO.getResultPrecautionaryExpertise());
            existingMotorcycle.setFairingCondition(updatedMotorcycleDTO.getFairingCondition());

            Motorcycle updatedMotorcycle = motorcycleRepository.update(existingMotorcycle);
            return toMotorcycleDTO(updatedMotorcycle);
        }
        return null;
    }

    public void deleteMotorcycle(Long id) {
        motorcycleRepository.deleteById(id);
    }

    private MotorcycleDTO toMotorcycleDTO(Motorcycle motorcycle) {
        MotorcycleDTO dto = new MotorcycleDTO();
        dto.setBrand(motorcycle.getBrand());
        dto.setManufactureYear(motorcycle.getManufactureYear());
        dto.setModel(motorcycle.getModel());
        dto.setDescription(motorcycle.getDescription());
        dto.setColor(motorcycle.getColor());
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
