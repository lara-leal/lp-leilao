package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {
}
