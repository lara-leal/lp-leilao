package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.DispositivoInformaticaDTO;
import lp.leilao.entities.devices.Monitor;
import lp.leilao.entities.devices.Notebook;
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

    public Iterable<DispositivoInformaticaDTO> getAllMonitor() {
        return toDispositivoInformaticaDTOList(monitorRepository.findAll());
    }

    public DispositivoInformaticaDTO getMonitorById(Long id) {
        return monitorRepository.findById(id)
                .map(this::toDispositivoInformaticaDTO)
                .orElse(null);
    }

    public DispositivoInformaticaDTO createMonitor(Monitor monitor) {
        Monitor savedMonitor = monitorRepository.save(monitor);
        return toDispositivoInformaticaDTO(savedMonitor);
    }


    public void deleteMonitor(Long id) {
        monitorRepository.deleteById(id);
    }


    private DispositivoInformaticaDTO toDispositivoInformaticaDTO(Monitor monitor) {
        DispositivoInformaticaDTO dto = new DispositivoInformaticaDTO();
        dto.setScreenSize(monitor.getScreenSize());
        dto.setRefreshRate(monitor.getRefreshRate());
        return dto;
    }

    private Iterable<DispositivoInformaticaDTO> toDispositivoInformaticaDTOList(Iterable<Monitor> monitors) {
        List<DispositivoInformaticaDTO> dtos = new ArrayList<>();
        for (Monitor monitor : monitors) {
            dtos.add(toDispositivoInformaticaDTO(monitor));
        }
        return dtos;
    }
}

