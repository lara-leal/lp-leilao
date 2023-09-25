package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Motorcycle;
@Repository
public interface MotorcycleRepository extends CrudRepository<Motorcycle,Long> {
}
