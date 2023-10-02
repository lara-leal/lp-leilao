package lp.leilao.controllers;


import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.ComputingDeviceDTO;
import lp.leilao.entities.devices.Switch;
import lp.leilao.services.SwitchService;

@Controller("/devices/switches")
public class SwitchController {

    @Inject
    private final SwitchService switchService;

    public SwitchController(SwitchService switchService) {
        this.switchService = switchService;
    }

    @Get("/list")
    public Iterable<ComputingDeviceDTO> listSwitches() {
        return switchService.getAllSwitches();
    }

    @Get("/{id}")
    public ComputingDeviceDTO getSwitches(Long id) {

        return switchService.getSwitchById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public ComputingDeviceDTO createSwitch(@Body @Valid Switch switches) {
        return switchService.createSwitch(switches);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteSwitch(Long id) {
        switchService.deleteSwitch(id);
    }
}