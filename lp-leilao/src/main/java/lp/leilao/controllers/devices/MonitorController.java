package lp.leilao.controllers.devices;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.devices.MonitorDTO;
import lp.leilao.entities.devices.Monitor;
import lp.leilao.services.devices.MonitorService;

@Controller("/devices/monitors")
public class MonitorController {

    @Inject
    private final MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @Get("/list")
    public Iterable<MonitorDTO> listMonitors() {
        return monitorService.getAllMonitor();
    }

    @Get("/{id}")
    public MonitorDTO getMonitor(Long id) {

        return monitorService.getMonitorById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public MonitorDTO createMonitor(@Body @Valid Monitor monitor) {
        return monitorService.createMonitor(monitor);
    }

    @Put("/{id}")
    public HttpResponse<MonitorDTO> updateMonitor(@PathVariable Long id, @Body MonitorDTO updatedMonitorDTO) {
        MonitorDTO updatedMonitor = monitorService.updateMonitor(id, updatedMonitorDTO);
        if (updatedMonitor != null) {
            return HttpResponse.ok(updatedMonitorDTO);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteMonitor(Long id) {
        monitorService.deleteMonitor(id);
    }
}
