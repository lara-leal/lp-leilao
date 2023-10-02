package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.ComputingDeviceDTO;
import lp.leilao.entities.devices.Router;
import lp.leilao.services.RouterService;

@Controller("/devices/routers")
public class RouterController {

    @Inject
    private final RouterService routerService;
    public RouterController(RouterService routerService){
        this.routerService = routerService;
    }

    @Get("/list")
    public Iterable<ComputingDeviceDTO> listRouter() {
        return routerService.getAllRouter();
    }

    @Get("/{id}")
    public ComputingDeviceDTO getRouter(Long id) {

        return routerService.getRouterById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public ComputingDeviceDTO createRouter(@Body @Valid Router router) {
        return routerService.createRouter(router);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteRouter(Long id) {
        routerService.deleteRouter(id);
    }
}
