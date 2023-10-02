package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.ComputingDeviceDTO;
import lp.leilao.entities.devices.Hub;
import lp.leilao.repositories.HubRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class HubService {
    @Inject
    private final HubRepository hubRepository;

    public HubService(HubRepository hubRepository) {
        this.hubRepository = hubRepository;
    }

    public Iterable<ComputingDeviceDTO> getAllHubs() {
        return toComputingDeviceDTOLits(hubRepository.findAll());
    }

    public ComputingDeviceDTO getHubById(Long id) {
        return hubRepository.findById(id)
                .map(this::toComputingDeviceDTO)
                .orElse(null);
    }

    public ComputingDeviceDTO createHub(Hub hub) {
        Hub savedHub = hubRepository.save(hub);
        return toComputingDeviceDTO(savedHub);
    }

    public void deleteHub(Long id) {
        hubRepository.deleteById(id);
    }

    private ComputingDeviceDTO toComputingDeviceDTO(Hub hub) {
        ComputingDeviceDTO dto = new ComputingDeviceDTO();
        dto.setPorts(hub.getPorts());
        dto.setVolts(hub.getVolts());
        return dto;
    }

    private Iterable<ComputingDeviceDTO> toComputingDeviceDTOLits(Iterable<Hub> Hubs) {
        List<ComputingDeviceDTO> dtos = new ArrayList<>();
        for (Hub hub : Hubs) {
            dtos.add(toComputingDeviceDTO(hub));
        }
        return dtos;
    }
}
