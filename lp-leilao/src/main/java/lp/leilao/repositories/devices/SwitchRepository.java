package lp.leilao.repositories.devices;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.devices.Switch;
@Repository
public interface SwitchRepository extends CrudRepository<Switch, Long> {
}
