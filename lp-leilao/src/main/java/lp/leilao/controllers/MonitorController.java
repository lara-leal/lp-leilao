package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.ComputingDeviceDTO;
import lp.leilao.entities.devices.Monitor;
import lp.leilao.services.MonitorService;

@Controller("/devices/monitors")
public class MonitorController {

    @Inject
    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @Get("/list")
    public Iterable<ComputingDeviceDTO> listMonitors() {
        return monitorService.getAllMonitor();
    }

    @Get("/{id}")
    public ComputingDeviceDTO getMonitor(Long id) {

        return monitorService.getMonitorById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public ComputingDeviceDTO createMonitor(@Body @Valid Monitor monitor) {
        return monitorService.createMonitor(monitor);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteMonitor(Long id) {
        monitorService.deleteMonitor(id);
    }
}
