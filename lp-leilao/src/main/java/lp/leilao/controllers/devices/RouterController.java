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
    public HttpResponse<RouterDTO> updateRouter(@PathVariable Long id, @Body RouterDTO updatedRouterDTO) {
        RouterDTO updatedRouter = routerService.updateRouter(id, updatedRouterDTO);
        if (updatedRouter != null) {
            return HttpResponse.ok(updatedRouterDTO);
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
