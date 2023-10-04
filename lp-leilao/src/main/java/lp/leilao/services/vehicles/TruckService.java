package lp.leilao.services.vehicles;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.vehicles.MotorcycleDTO;
import lp.leilao.dtos.vehicles.TruckDTO;
import lp.leilao.entities.vehicles.Motorcycle;
import lp.leilao.entities.vehicles.Truck;
import lp.leilao.repositories.vehicles.TruckRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class TruckService {
    @Inject
    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public Iterable<TruckDTO> getAllTrucks() {
        return toTruckDTOList(truckRepository.findAll());
    }

    public TruckDTO getTruckById(Long id) {
        return truckRepository.findById(id)
                .map(this::toTruckDTO)
                .orElse(null);
    }

    public TruckDTO createTruck(Truck truck) {
        return toTruckDTO(truckRepository.save(truck));
    }

    public void deleteTruck(Long id) {
        truckRepository.deleteById(id);
    }

    private TruckDTO toTruckDTO(Truck truck) {
        TruckDTO dto = new TruckDTO();
       dto.setCargoCapacity(truck.getCargoCapacity());
       dto.setEngineType(truck.getEngineType());

        return dto;
    }

    private Iterable<TruckDTO> toTruckDTOList(Iterable<Truck> trucks) {
        List<TruckDTO> dtos = new ArrayList<>();
        for (Truck truck : trucks) {
            dtos.add(toTruckDTO(truck));
        }
        return dtos;
    }
}
