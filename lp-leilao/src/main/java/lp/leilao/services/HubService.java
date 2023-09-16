package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Hub;
import lp.leilao.entities.Roteador;
import lp.leilao.repositories.HubRepository;
import lp.leilao.repositories.RoteadorRepository;

@Singleton
public class HubService {
    @Inject
    private final HubRepository hubRepository;

    public HubService(HubRepository hubRepository) {
        this.hubRepository = hubRepository;
    }

    public Iterable<Hub> getAllHubs() {
        return hubRepository.findAll();
    }

    public Hub getHubById(Long id) {
        return hubRepository.findById(id).orElse(null);
    }

    public Hub createHub(Hub hub) {
        return hubRepository.save(hub);
    }

    public void deleteHub(Long id) {
        hubRepository.deleteById(id);
    }
}
