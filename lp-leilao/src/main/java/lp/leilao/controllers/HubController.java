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
import lp.leilao.entities.devices.Hub;
import lp.leilao.services.HubService;

@Controller("/dispositivos/hubs")
public class HubController {

    @Inject
    private final HubService hubService;

    public HubController(HubService hubService) {
        this.hubService = hubService;
    }

    @Get("/list")
    public Iterable<DispositivoInformaticaDTO> listarHubs() {
        return hubService.getAllHubs();
    }

    @Get("/{id}")
    public DispositivoInformaticaDTO getHubs(Long id) {

        return hubService.getHubById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public DispositivoInformaticaDTO criarHub(@Body @Valid Hub hub) {
        return hubService.createHub(hub);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deletarHub(Long id) {
        hubService.deleteHub(id);
    }
}
