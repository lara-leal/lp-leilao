package lp.leilao.repositories.devices;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.devices.Monitor;

@Repository
public interface MonitorRepository extends CrudRepository<Monitor, Long> {
}
