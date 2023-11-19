package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.ClientDTO;
import lp.leilao.dtos.converter.AuctionMapper;
import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.entities.Client;
import lp.leilao.exceptions.NoResultsFound;
import lp.leilao.repositories.ClientRepository;

import java.util.List;

@Singleton
public class ClientService {

    private final ClientRepository clientRepository;

    private final AuctionMapper mapper = new AuctionMapperImpl();

    @Inject
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClient() {
        List<Client> client = clientRepository.findAll();
        if (client.isEmpty()){
            throw new NoResultsFound();
        }
        return client;
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).
                orElseThrow(NoResultsFound::new);

    }

    public Client createClient(ClientDTO client) {
        try {
            return clientRepository.save(mapper.ClientDtoToEntity(client));
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }

    }

    public void updateClient(Long id, ClientDTO updatedClient) {
        Client client = getClientById(id);

        client = updateMapper(client, updatedClient);

        clientRepository.update(client);
    }

    private Client updateMapper(Client client, ClientDTO updatedClient) {
        client.setName(updatedClient.getName() != null ? updatedClient.getName() : client.getName());
        client.setDigitalCertificate(updatedClient.getDigitalCertificate()
                != null ? updatedClient.getDigitalCertificate() : client.getDigitalCertificate());
        client.setEmail(updatedClient.getEmail() != null ? updatedClient.getEmail() : client.getEmail());
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
        return clientRepository.findByCpf(cpf).
                orElseThrow(NoResultsFound::new);
    }
}
