package lp.leilao.repositories.vehicles;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.vehicles.Car;
@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
}
