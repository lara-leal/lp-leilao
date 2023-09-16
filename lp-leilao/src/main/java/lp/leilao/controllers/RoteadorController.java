package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Roteador;
import lp.leilao.services.RoteadorService;
@Controller("/dispositivos/roteadores")
public class RoteadorController {

    @Inject
    private final RoteadorService roteadorService;

    public RoteadorController(RoteadorService roteadorService) {
        this.roteadorService = roteadorService;
    }

    @Get("/list")
    public Iterable<Roteador> listarRoteadores() {
        return roteadorService.getAllRoteador();
    }

    @Get("/{id}")
    public Roteador getRoteador(Long id) {

        return roteadorService.getRoteadorById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Roteador criarRoteador(@Body @Valid Roteador roteador) {
        return roteadorService.createRoteador(roteador);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deletarDispositivo(Long id) {
        roteadorService.deleteRoteador(id);
    }
}
