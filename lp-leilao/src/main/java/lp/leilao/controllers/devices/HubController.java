package lp.leilao.controllers.devices;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.devices.HubDTO;
import lp.leilao.entities.Client;
import lp.leilao.entities.devices.Hub;
import lp.leilao.services.devices.HubService;

@Controller("/devices/hubs")
public class HubController {

    @Inject
    private final HubService hubService;

    public HubController(HubService hubService) {
        this.hubService = hubService;
    }

    @Get("/list")
    public Iterable<HubDTO> listHubs() {
        return hubService.getAllHubs();
    }

    @Get("/{id}")
    public HubDTO getHubs(Long id) {

        return hubService.getHubById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public HubDTO createHub(@Body @Valid Hub hub) {
        return hubService.createHub(hub);
    }


//    @Put("/{id}")
//    public HttpResponse<Hub> updateHub(@PathVariable Long id, @Body Hub updatedHub) {
//        Hub updated = hubService.updateHub(id, updatedHub);
//        if (updated != null) {
//            return HttpResponse.ok(updated);
//        } else {
//            return HttpResponse.notFound();
//        }
//    }
    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteHub(Long id) {
        hubService.deleteHub(id);
    }
}
