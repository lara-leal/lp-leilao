package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository <Client,Long> {
}
