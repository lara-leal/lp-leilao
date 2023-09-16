package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Roteador;
import lp.leilao.repositories.RoteadorRepository;

@Singleton
public class RoteadorService {
    @Inject
    private final RoteadorRepository roteadorRepository;

    public RoteadorService(RoteadorRepository roteadorRepository) {
        this.roteadorRepository = roteadorRepository;
    }

    public Iterable<Roteador> getAllRoteador() {
        return roteadorRepository.findAll();
    }

    public Roteador getRoteadorById(Long id) {
        return roteadorRepository.findById(id).orElse(null);
    }

    public Roteador createRoteador(Roteador roteador) {
        return roteadorRepository.save(roteador);
    }

    public void deleteRoteador(Long id) {
        roteadorRepository.deleteById(id);
    }
}
