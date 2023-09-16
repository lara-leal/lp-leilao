package lp.leilao.services;

import jakarta.inject.Inject;
import lp.leilao.entities.Client;
import lp.leilao.entities.Hub;
import lp.leilao.repositories.ClientRepository;
import lp.leilao.repositories.HubRepository;

public class ClientService {
    @Inject
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Iterable<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}