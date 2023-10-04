package lp.leilao.repositories.vehicles;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.vehicles.Truck;
@Repository
public interface TruckRepository extends CrudRepository<Truck,Long> {
}
