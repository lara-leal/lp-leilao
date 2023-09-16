package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.DispositivoInformatica;
import lp.leilao.repositories.DispositivoInformaticaRepository;

@Singleton
public class DispositivoInformaticaService {
    @Inject
    private final DispositivoInformaticaRepository dispoRepository;

    public DispositivoInformaticaService(DispositivoInformaticaRepository dispoRepository) {
        this.dispoRepository = dispoRepository;
    }

    public Iterable<DispositivoInformatica> getAllDispo() {
        return dispoRepository.findAll();
    }

    public DispositivoInformatica getDispoById(Long id) {
        return dispoRepository.findById(id).orElse(null);
    }

    public DispositivoInformatica createDispo(DispositivoInformatica dispo) {

        return dispoRepository.save(dispo);
    }

    public void deleteDispo(Long id) {
        dispoRepository.deleteById(id);
    }
}
