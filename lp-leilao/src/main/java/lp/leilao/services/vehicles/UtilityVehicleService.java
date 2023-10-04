package lp.leilao.services.vehicles;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.vehicles.TruckDTO;
import lp.leilao.dtos.vehicles.UtilityVehicleDTO;
import lp.leilao.entities.vehicles.Truck;
import lp.leilao.entities.vehicles.UtilityVehicle;
import lp.leilao.repositories.vehicles.UtilityVehicleRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class UtilityVehicleService {
    @Inject
    private final UtilityVehicleRepository utilityVehicleRepository;

    public UtilityVehicleService(UtilityVehicleRepository utilityVehicleRepository) {
        this.utilityVehicleRepository = utilityVehicleRepository;
    }

    public Iterable<UtilityVehicleDTO> getAllUtilityVehicles() {
        return toUtilityVehicleDTOList(utilityVehicleRepository.findAll());
    }

    public UtilityVehicleDTO getUtilityVehicleById(Long id) {
        return utilityVehicleRepository.findById(id)
                .map(this::toUtilityVehicleDTO)
                .orElse(null);
    }

    public UtilityVehicleDTO createUtilityVehicle(UtilityVehicle utilityVehicle) {
        return toUtilityVehicleDTO(utilityVehicleRepository.save(utilityVehicle));
    }

    public void deleteUtilityVehicle(Long id) {
        utilityVehicleRepository.deleteById(id);
    }

    private UtilityVehicleDTO toUtilityVehicleDTO(UtilityVehicle utilityVehicle) {
        UtilityVehicleDTO dto = new UtilityVehicleDTO();
        dto.setGroundClearance(utilityVehicle.getGroundClearance());
        dto.setTractionType(utilityVehicle.getTractionType());

        return dto;
    }

    private Iterable<UtilityVehicleDTO> toUtilityVehicleDTOList(Iterable<UtilityVehicle> utilitys) {
        List<UtilityVehicleDTO> dtos = new ArrayList<>();
        for (UtilityVehicle utility : utilitys) {
            dtos.add(toUtilityVehicleDTO(utility));
        }
        return dtos;
    }
}
