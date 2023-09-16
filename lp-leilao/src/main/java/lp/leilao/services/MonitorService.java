package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Monitor;
import lp.leilao.entities.Notebook;
import lp.leilao.repositories.MonitorRepository;
import lp.leilao.repositories.NotebookRepository;
@Singleton
public class MonitorService {
    @Inject
    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public Iterable<Monitor> getAllMonitor() {
        return monitorRepository.findAll();
    }

    public Monitor getMonitorById(Long id) {
        return monitorRepository.findById(id).orElse(null);
    }

    public Monitor createMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public void deleteMonitor(Long id) {
        monitorRepository.deleteById(id);
    }
}

