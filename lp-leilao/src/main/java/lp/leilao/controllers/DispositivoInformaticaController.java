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
import lp.leilao.entities.devices.DispositivoInformatica;
import lp.leilao.services.DispositivoInformaticaService;

@Controller("/dispositivos")
public class DispositivoInformaticaController {

    @Inject
    private final DispositivoInformaticaService dispoService;

    public DispositivoInformaticaController(DispositivoInformaticaService dispoService) {
        this.dispoService = dispoService;
    }

    @Get("/list")
    public Iterable<DispositivoInformatica> listarDispositivos() {
        return dispoService.getAllDispo();
    }

    @Get("/{id}")
    public DispositivoInformatica getDispositivo(Long id) {

        return dispoService.getDispoById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public DispositivoInformatica criarDispositivo(@Body @Valid DispositivoInformatica dispositivo) {
        return dispoService.createDispo(dispositivo);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deletarDispositivo(Long id) {
        dispoService.deleteDispo(id);
    }
}
