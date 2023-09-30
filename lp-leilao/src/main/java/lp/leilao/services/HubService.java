package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.DispositivoInformaticaDTO;
import lp.leilao.entities.devices.Hub;
import lp.leilao.entities.devices.Notebook;
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

    public Iterable<DispositivoInformaticaDTO> getAllHubs() {
        return toDispositivoInformaticaDTOList(hubRepository.findAll());
    }

    public DispositivoInformaticaDTO getHubById(Long id) {
        return hubRepository.findById(id)
                .map(this::toDispositivoInformaticaDTO)
                .orElse(null);
    }

    public DispositivoInformaticaDTO createHub(Hub hub) {
        Hub savedHub = hubRepository.save(hub);
        return toDispositivoInformaticaDTO(savedHub);
    }

    public void deleteHub(Long id) {
        hubRepository.deleteById(id);
    }

    private DispositivoInformaticaDTO toDispositivoInformaticaDTO(Hub hub) {
        DispositivoInformaticaDTO dto = new DispositivoInformaticaDTO();
        dto.setPorts(hub.getPorts());
        dto.setVolts(hub.getVolts());
        return dto;
    }

    private Iterable<DispositivoInformaticaDTO> toDispositivoInformaticaDTOList(Iterable<Hub> Hubs) {
        List<DispositivoInformaticaDTO> dtos = new ArrayList<>();
        for (Hub hub : Hubs) {
            dtos.add(toDispositivoInformaticaDTO(hub));
        }
        return dtos;
    }
}
