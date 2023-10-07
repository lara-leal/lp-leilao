package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Client;
import lp.leilao.services.ClientService;

@Controller("/clients")
@Tag(name = "Clients")
public class ClientController {
    @Inject
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Get("/list")
    public Iterable<Client> listClient() {
        return clientService.getAllClient();
    }

    @Get("/{id_client}")
    public Client getClient(Long id_client) {

        return clientService.getClientById(id_client);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Client createClient(@Body @Valid Client client) {
        return clientService.createClient(client);
    }

    @Put("/{id_client}")
    public HttpResponse<Client> updateClient(@PathVariable Long id_client, @Body Client updatedClient) {
        Client updated = clientService.updateClient(id_client, updatedClient);
        if (updated != null) {
            return HttpResponse.ok(updated);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id_client}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteClient(Long id_client) {
        clientService.deleteClient(id_client);
    }
}
