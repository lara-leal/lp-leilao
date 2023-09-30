package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.DispositivoInformaticaDTO;
import lp.leilao.entities.devices.Monitor;
import lp.leilao.entities.devices.Switch;
import lp.leilao.repositories.SwitchRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class SwitchService {
    @Inject
    private final SwitchRepository switchRepository;

    public SwitchService(SwitchRepository switchRepository) {
        this.switchRepository = switchRepository;
    }

    public Iterable<DispositivoInformaticaDTO> getAllSwitches() {
        return toDispositivoInformaticaDTOList(switchRepository.findAll());
    }

    public DispositivoInformaticaDTO getSwitchById(Long id) {
        return switchRepository.findById(id)
                .map(this::toDispositivoInformaticaDTO)
                .orElse(null);
    }

    public DispositivoInformaticaDTO createSwitch(Switch switches) {
        Switch savedSwitch = switchRepository.save(switches);
        return toDispositivoInformaticaDTO(savedSwitch);
    }
    public void deleteSwitch(Long id) {
        switchRepository.deleteById(id);
    }

    private DispositivoInformaticaDTO toDispositivoInformaticaDTO(Switch swi) {
        DispositivoInformaticaDTO dto = new DispositivoInformaticaDTO();
        dto.setNumberOfPorts(swi.getNumberOfPorts());
        dto.setFirmwareVersion(swi.getFirmwareVersion());
        return dto;
    }

    private Iterable<DispositivoInformaticaDTO> toDispositivoInformaticaDTOList(Iterable<Switch> swits) {
        List<DispositivoInformaticaDTO> dtos = new ArrayList<>();
        for (Switch swit : swits) {
            dtos.add(toDispositivoInformaticaDTO(swit));
        }
        return dtos;
    }

}

