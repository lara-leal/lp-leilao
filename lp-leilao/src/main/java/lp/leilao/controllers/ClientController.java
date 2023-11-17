package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Client;
import lp.leilao.services.ClientService;

import java.util.List;

@Controller("/client")
@Tag(name = "Client")
public class ClientController {

    private final ClientService clientService;

    @Inject
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Get("/find-clients")
    public HttpResponse<List<Client>> allClients() {
        return HttpResponse.ok().body(clientService.getAllClient());
    }

    @Get("/find-client/{id}")
    public HttpResponse<Client> findClientById(Long id) {
        return HttpResponse.ok().body(clientService.getClientById(id));
    }

    @Post("/register")
    public HttpResponse<?> registerClient(@Body @Valid Client client) {
        clientService.createClient(client);
        return HttpResponse.created("Register with successfully");
    }

    @Put("/update-client/{id}")
    public HttpResponse<?> updateClient(@PathVariable Long id, @Body Client updatedClient) {
        clientService.updateClient(id, updatedClient);
        return HttpResponse.ok().body("Update with successfully");
    }

    @Delete("/delete/{id}")
    public HttpResponse deleteClient(Long id) {
        clientService.deleteClient(id);
        return HttpResponse.noContent().body("Delete with successfully");
    }
}
