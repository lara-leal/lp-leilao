package lp.leilao.services.devices;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.devices.MonitorDTO;
import lp.leilao.entities.devices.Monitor;
import lp.leilao.repositories.devices.MonitorRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MonitorService {
    @Inject
    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public Iterable<MonitorDTO> getAllMonitor() {
        return toMonitorDTOList(monitorRepository.findAll());
    }

    public MonitorDTO getMonitorById(Long id) {
        return monitorRepository.findById(id)
                .map(this::toMonitorDTO)
                .orElse(null);
    }

    public MonitorDTO createMonitor(Monitor monitor) {
        Monitor savedMonitor = monitorRepository.save(monitor);
        return toMonitorDTO(savedMonitor);
    }


    public void deleteMonitor(Long id) {
        monitorRepository.deleteById(id);
    }


    private MonitorDTO toMonitorDTO(Monitor monitor) {
        MonitorDTO dto = new MonitorDTO();
        dto.setScreenSize(monitor.getScreenSize());
        dto.setRefreshRate(monitor.getRefreshRate());
        return dto;
    }

    private Iterable<MonitorDTO> toMonitorDTOList(Iterable<Monitor> monitors) {
        List<MonitorDTO> dtos = new ArrayList<>();
        for (Monitor monitor : monitors) {
            dtos.add(toMonitorDTO(monitor));
        }
        return dtos;
    }
}

