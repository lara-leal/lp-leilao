package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.ComputingDeviceDTO;
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

    public Iterable<ComputingDeviceDTO> getAllSwitches() {
        return toComputingDeviceDTOList(switchRepository.findAll());
    }

    public ComputingDeviceDTO getSwitchById(Long id) {
        return switchRepository.findById(id)
                .map(this::toComputingDeviceDTO)
                .orElse(null);
    }

    public ComputingDeviceDTO createSwitch(Switch switches) {
        Switch savedSwitch = switchRepository.save(switches);
        return toComputingDeviceDTO(savedSwitch);
    }
    public void deleteSwitch(Long id) {
        switchRepository.deleteById(id);
    }

    private ComputingDeviceDTO toComputingDeviceDTO(Switch swi) {
        ComputingDeviceDTO dto = new ComputingDeviceDTO();
        dto.setNumberOfPorts(swi.getNumberOfPorts());
        dto.setFirmwareVersion(swi.getFirmwareVersion());
        return dto;
    }

    private Iterable<ComputingDeviceDTO> toComputingDeviceDTOList(Iterable<Switch> swits) {
        List<ComputingDeviceDTO> dtos = new ArrayList<>();
        for (Switch swit : swits) {
            dtos.add(toComputingDeviceDTO(swit));
        }
        return dtos;
    }

}

