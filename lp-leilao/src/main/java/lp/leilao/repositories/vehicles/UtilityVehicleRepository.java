package lp.leilao.repositories.vehicles;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.vehicles.UtilityVehicle;
@Repository
public interface UtilityVehicleRepository extends CrudRepository<UtilityVehicle,Long> {
}
