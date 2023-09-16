package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Switch;
@Repository
public interface SwitchRepository extends CrudRepository<Switch, Long> {
}
