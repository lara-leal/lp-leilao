package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.DispositivoInformaticaDTO;
import lp.leilao.entities.devices.Monitor;
import lp.leilao.entities.devices.Roteador;
import lp.leilao.repositories.RoteadorRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class RoteadorService {
    @Inject
    private final RoteadorRepository roteadorRepository;

    public RoteadorService(RoteadorRepository roteadorRepository) {
        this.roteadorRepository = roteadorRepository;
    }

    public Iterable<DispositivoInformaticaDTO> getAllRoteador() {
        return toDispositivoInformaticaDTOList(roteadorRepository.findAll());
    }

    public DispositivoInformaticaDTO getRoteadorById(Long id) {
        return roteadorRepository.findById(id)
                .map(this::toDispositivoInformaticaDTO)
                .orElse(null);
    }

    public DispositivoInformaticaDTO createRoteador(Roteador roteador) {
        Roteador savedRoteador = roteadorRepository.save(roteador);
        return toDispositivoInformaticaDTO(savedRoteador);
    }

    public void deleteRoteador(Long id) {
        roteadorRepository.deleteById(id);
    }

    private DispositivoInformaticaDTO toDispositivoInformaticaDTO(Roteador roteador) {
        DispositivoInformaticaDTO dto = new DispositivoInformaticaDTO();
        dto.setAntenna(roteador.getAntenna());
        return dto;
    }

    private Iterable<DispositivoInformaticaDTO> toDispositivoInformaticaDTOList(Iterable<Roteador> roteadores) {
        List<DispositivoInformaticaDTO> dtos = new ArrayList<>();
        for (Roteador roteador : roteadores) {
            dtos.add(toDispositivoInformaticaDTO(roteador));
        }
        return dtos;
    }
}
