package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Monitor;

@Repository
public interface MonitorRepository extends CrudRepository<Monitor, Long> {
}
