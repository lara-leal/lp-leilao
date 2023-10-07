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

    public MonitorDTO updateMonitor(Long id, MonitorDTO updatedMonitorDTO) {
        Monitor existingMonitor = monitorRepository.findById(id).orElse(null);
        if (existingMonitor != null) {
            existingMonitor.setName(updatedMonitorDTO.getName());
            existingMonitor.setQuantity(updatedMonitorDTO.getQuantity());
            existingMonitor.setBrand(updatedMonitorDTO.getBrand());
            existingMonitor.setScreenSize(updatedMonitorDTO.getScreenSize());
            existingMonitor.setRefreshRate(updatedMonitorDTO.getRefreshRate());

            Monitor updatedMonitor = monitorRepository.update(existingMonitor);
            return toMonitorDTO(updatedMonitor);
        }
        return null;
    }

    public void deleteMonitor(Long id) {
        monitorRepository.deleteById(id);
    }

    private MonitorDTO toMonitorDTO(Monitor monitor) {
        MonitorDTO dto = new MonitorDTO();
        dto.setName(monitor.getName());
        dto.setQuantity(monitor.getQuantity());
        dto.setBrand(monitor.getBrand());
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
