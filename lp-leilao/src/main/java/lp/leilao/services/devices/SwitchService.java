package lp.leilao.services.devices;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.devices.SwitchDTO;
import lp.leilao.entities.devices.Switch;
import lp.leilao.repositories.devices.SwitchRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class SwitchService {
    @Inject
    private final SwitchRepository switchRepository;

    public SwitchService(SwitchRepository switchRepository) {
        this.switchRepository = switchRepository;
    }

    public Iterable<SwitchDTO> getAllSwitches() {
        return toSwitchDTOList(switchRepository.findAll());
    }

    public SwitchDTO getSwitchById(Long id) {
        return switchRepository.findById(id)
                .map(this::toSwitchDTO)
                .orElse(null);
    }

    public SwitchDTO createSwitch(Switch switches) {
        Switch savedSwitch = switchRepository.save(switches);
        return toSwitchDTO(savedSwitch);
    }

    public Switch updateSwitch(Long id, Switch updatedSwitch) {
        Switch existingSwitch = switchRepository.findById(id).orElse(null);
        if (existingSwitch != null) {
            existingSwitch.setName(updatedSwitch.getName());
            existingSwitch.setQuantity(updatedSwitch.getQuantity());
            existingSwitch.setDeviceValue(updatedSwitch.getDeviceValue());
            existingSwitch.setBrand(updatedSwitch.getBrand());
            existingSwitch.setNumberOfPorts(updatedSwitch.getNumberOfPorts());
            existingSwitch.setFirmwareVersion(updatedSwitch.getFirmwareVersion());
            return switchRepository.update(existingSwitch);
        }
        return null;
    }

    public void deleteSwitch(Long id) {
        switchRepository.deleteById(id);
    }

    private SwitchDTO toSwitchDTO(Switch swi) {
        SwitchDTO dto = new SwitchDTO();
        dto.setNumberOfPorts(swi.getNumberOfPorts());
        dto.setFirmwareVersion(swi.getFirmwareVersion());
        return dto;
    }

    private Iterable<SwitchDTO> toSwitchDTOList(Iterable<Switch> swits) {
        List<SwitchDTO> dtos = new ArrayList<>();
        for (Switch swit : swits) {
            dtos.add(toSwitchDTO(swit));
        }
        return dtos;
    }

}
