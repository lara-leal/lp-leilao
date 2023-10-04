package lp.leilao.repositories.vehicles;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.vehicles.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {
}
