package lp.leilao.services;

import jakarta.inject.Inject;
import lp.leilao.entities.Client;
import lp.leilao.repositories.ClientRepository;

public class ClientService {
    @Inject
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Iterable<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id_client) {
        return clientRepository.findById(id_client).orElse(null);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id_client, Client updatedClient) {
        Client existingClient = clientRepository.findById(id_client).orElse(null);
        if (existingClient != null) {
            existingClient.setName(updatedClient.getName());
            existingClient.setCpf(updatedClient.getCpf());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setDigitalCertificate(updatedClient.getDigitalCertificate());

            return clientRepository.update(existingClient);
        }
        return null;
    }

    public void deleteClient(Long id_client) {
        clientRepository.deleteById(id_client);
    }

}
