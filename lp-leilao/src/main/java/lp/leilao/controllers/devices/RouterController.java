package lp.leilao.controllers.devices;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.devices.RouterDTO;
import lp.leilao.entities.devices.Router;
import lp.leilao.services.devices.RouterService;

@Controller("/devices/routers")
public class RouterController {

    @Inject
    private final RouterService routerService;

    public RouterController(RouterService routerService) {
        this.routerService = routerService;
    }

    @Get("/list")
    public Iterable<RouterDTO> listRouter() {
        return routerService.getAllRouter();
    }

    @Get("/{id}")
    public RouterDTO getRouter(Long id) {

        return routerService.getRouterById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public RouterDTO createRouter(@Body @Valid Router router) {
        return routerService.createRouter(router);
    }

    @Put("/{id}")
    public HttpResponse<Router> updateRouter(@PathVariable Long id, @Body Router updatedRouter) {
        Router updated = routerService.updateRouter(id, updatedRouter);
        if (updated != null) {
            return HttpResponse.ok(updated);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteRouter(Long id) {
        routerService.deleteRouter(id);
    }
}
