package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.ComputingDeviceDTO;
import lp.leilao.entities.devices.Monitor;
import lp.leilao.repositories.MonitorRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MonitorService {
    @Inject
    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public Iterable<ComputingDeviceDTO> getAllMonitor() {
        return toComputingDeviceDTOList(monitorRepository.findAll());
    }

    public ComputingDeviceDTO getMonitorById(Long id) {
        return monitorRepository.findById(id)
                .map(this::toComputingDeviceDTO)
                .orElse(null);
    }

    public ComputingDeviceDTO createMonitor(Monitor monitor) {
        Monitor savedMonitor = monitorRepository.save(monitor);
        return toComputingDeviceDTO(savedMonitor);
    }


    public void deleteMonitor(Long id) {
        monitorRepository.deleteById(id);
    }


    private ComputingDeviceDTO toComputingDeviceDTO(Monitor monitor) {
        ComputingDeviceDTO dto = new ComputingDeviceDTO();
        dto.setScreenSize(monitor.getScreenSize());
        dto.setRefreshRate(monitor.getRefreshRate());
        return dto;
    }

    private Iterable<ComputingDeviceDTO> toComputingDeviceDTOList(Iterable<Monitor> monitors) {
        List<ComputingDeviceDTO> dtos = new ArrayList<>();
        for (Monitor monitor : monitors) {
            dtos.add(toComputingDeviceDTO(monitor));
        }
        return dtos;
    }
}

