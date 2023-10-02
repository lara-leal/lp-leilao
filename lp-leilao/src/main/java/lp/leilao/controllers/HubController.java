package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.ComputingDeviceDTO;
import lp.leilao.entities.devices.Hub;
import lp.leilao.services.HubService;

@Controller("/devices/hubs")
public class HubController {

    @Inject
    private final HubService hubService;

    public HubController(HubService hubService) {
        this.hubService = hubService;
    }

    @Get("/list")
    public Iterable<ComputingDeviceDTO> listHubs() {
        return hubService.getAllHubs();
    }

    @Get("/{id}")
    public ComputingDeviceDTO getHubs(Long id) {

        return hubService.getHubById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public ComputingDeviceDTO createHub(@Body @Valid Hub hub) {
        return hubService.createHub(hub);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteHub(Long id) {
        hubService.deleteHub(id);
    }
}
