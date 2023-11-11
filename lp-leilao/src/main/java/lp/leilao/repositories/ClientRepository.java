package lp.leilao.repositories;

import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
