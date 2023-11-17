package lp.leilao.services;

import jakarta.inject.Inject;
import lp.leilao.entities.Client;
import lp.leilao.exceptions.NoResultsFound;
import lp.leilao.repositories.ClientRepository;

import java.util.List;

public class ClientService {

    private final ClientRepository clientRepository;

    @Inject
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClient() {
        try {
            List<Client> client = clientRepository.findAll();
            if (client.isEmpty()){
                throw new NoResultsFound();
            }
            return client;
        }catch (NoResultsFound e){
            throw new NoResultsFound();
        }

    }

    public Client getClientById(Long id) {
        try {
            return clientRepository.findById(id).
                    orElseThrow(NoResultsFound::new);
        }catch (NoResultsFound e){
            throw new NoResultsFound();
        }

    }

    public Client createClient(Client client) {
        try {
            return clientRepository.save(client);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public void updateClient(Long id, Client updatedClient) {
        try {
            Client client = getClientById(id);

            client = updateMapper(client, updatedClient);

            clientRepository.update(client);
        } catch (NoResultsFound e) {
            throw new NoResultsFound();
        }
    }

    private Client updateMapper(Client client, Client updatedClient) {
//        client.setName(updatedClient.getName() != null ? updatedClient.getName() : client.getName());
//        client.setDigitalCertificate(updatedClient.getDigitalCertificate()
//                != null ? updatedClient.getDigitalCertificate() : client.getDigitalCertificate());
//        client.setEmail(updatedClient.getEmail() != null ? updatedClient.getEmail() : client.getEmail());
//        client.setCpf(updatedClient.getCpf() != null ? updatedClient.getCpf() : client.getCpf());

        return client;
    }

    public void deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Client getClientByCpf(String cpf) {
        try {
            return (Client) clientRepository.findByCpf(cpf).
                    orElseThrow(NoResultsFound::new);
        }catch (NoResultsFound e){
            throw new NoResultsFound();
        }
    }
}
