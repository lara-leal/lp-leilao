package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Client;
import lp.leilao.services.ClientService;
@Controller("/clients")
public class ClientController {
    @Inject
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Get("/list")
    public Iterable<Client> listarClient() {
        return clientService.getAllClient();
    }

    @Get("/{id}")
    public Client getClient(Long id) {

        return clientService.getClientById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Client createClient(@Body @Valid Client client) {
        return clientService.createClient(client);
    }

    @Put("/{id}")
    public HttpResponse<Client> updateClient(Long id, @Body Client updatedClient) {
        Client updated = clientService.updateClient(id, updatedClient);
        if (updated != null) {
            return HttpResponse.ok(updated);
        } else {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deletarClient(Long id) {
        clientService.deleteClient(id);
    }
}
