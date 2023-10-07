package lp.leilao.controllers.devices;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.devices.SwitchDTO;
import lp.leilao.entities.devices.Switch;
import lp.leilao.services.devices.SwitchService;

@Controller("/devices/switches")
@Tag(name = "Devices/Switches")

public class SwitchController {

    @Inject
    private final SwitchService switchService;

    public SwitchController(SwitchService switchService) {
        this.switchService = switchService;
    }

    @Get("/list")
    public Iterable<SwitchDTO> listSwitches() {
        return switchService.getAllSwitches();
    }

    @Get("/{id}")
    public SwitchDTO getSwitches(Long id) {

        return switchService.getSwitchById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public SwitchDTO createSwitch(@Body @Valid Switch switches) {
        return switchService.createSwitch(switches);
    }

    @Put("/{id}")
    public HttpResponse<SwitchDTO> updateSwitch(@PathVariable Long id, @Body SwitchDTO updatedSwitchDTO) {
        SwitchDTO updatedSwitch = switchService.updateSwitch(id, updatedSwitchDTO);
        if (updatedSwitch != null) {
            return HttpResponse.ok(updatedSwitchDTO);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteSwitch(Long id) {
        switchService.deleteSwitch(id);
    }
}