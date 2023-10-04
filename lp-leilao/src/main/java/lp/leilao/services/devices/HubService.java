package lp.leilao.services.devices;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.devices.HubDTO;
import lp.leilao.entities.devices.Hub;
import lp.leilao.repositories.devices.HubRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class HubService {
    @Inject
    private final HubRepository hubRepository;

    public HubService(HubRepository hubRepository) {
        this.hubRepository = hubRepository;
    }

    public Iterable<HubDTO> getAllHubs() {
        return toHubDTOList(hubRepository.findAll());
    }

    public HubDTO getHubById(Long id) {
        return hubRepository.findById(id)
                .map(this::toHubDTO)
                .orElse(null);
    }

    public HubDTO createHub(Hub hub) {

        return toHubDTO(hubRepository.save(hub));
    }

    public void deleteHub(Long id) {
        hubRepository.deleteById(id);
    }

    private HubDTO toHubDTO(Hub hub) {
        HubDTO dto = new HubDTO();
        dto.setPorts(hub.getPorts());
        dto.setVolts(hub.getVolts());
        return dto;
    }

    private Iterable<HubDTO> toHubDTOList(Iterable<Hub> Hubs) {
        List<HubDTO> dtos = new ArrayList<>();
        for (Hub hub : Hubs) {
            dtos.add(toHubDTO(hub));
        }
        return dtos;
    }
}
