package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.DispositivoInformaticaDTO;
import lp.leilao.entities.devices.Monitor;
import lp.leilao.services.MonitorService;

@Controller("/dispositivos/monitores")
public class MonitorController {

    @Inject
    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @Get("/list")
    public Iterable<DispositivoInformaticaDTO> listarMonitores() {
        return monitorService.getAllMonitor();
    }

    @Get("/{id}")
    public DispositivoInformaticaDTO getMonitor(Long id) {

        return monitorService.getMonitorById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public DispositivoInformaticaDTO criarMonitor(@Body @Valid Monitor monitor) {
        return monitorService.createMonitor(monitor);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deletarMonitor(Long id) {
        monitorService.deleteMonitor(id);
    }
}
