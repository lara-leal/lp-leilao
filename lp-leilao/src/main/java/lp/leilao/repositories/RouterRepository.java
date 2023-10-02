package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.devices.Router;

@Repository
public interface RouterRepository  extends CrudRepository<Router, Long> {
}
