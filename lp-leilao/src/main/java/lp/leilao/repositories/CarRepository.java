package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.vehicles.Car;
@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
}
