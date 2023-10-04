package lp.leilao.repositories.vehicles;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.vehicles.Motorcycle;
@Repository
public interface MotorcycleRepository extends CrudRepository<Motorcycle,Long> {
}
