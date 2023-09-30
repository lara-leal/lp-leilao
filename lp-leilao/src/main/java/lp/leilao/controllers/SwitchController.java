package lp.leilao.controllers;


import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.DispositivoInformaticaDTO;
import lp.leilao.entities.devices.Switch;
import lp.leilao.services.SwitchService;

@Controller("/dispositivos/switches")
public class SwitchController {

    @Inject
    private final SwitchService switchService;

    public SwitchController(SwitchService switchService) {
        this.switchService = switchService;
    }

    @Get("/list")
    public Iterable<DispositivoInformaticaDTO> listarSwitches() {
        return switchService.getAllSwitches();
    }

    @Get("/{id}")
    public DispositivoInformaticaDTO getSwitches(Long id) {

        return switchService.getSwitchById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public DispositivoInformaticaDTO criarSwitch(@Body @Valid Switch switches) {
        return switchService.createSwitch(switches);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deletarSwitch(Long id) {
        switchService.deleteSwitch(id);
    }
}