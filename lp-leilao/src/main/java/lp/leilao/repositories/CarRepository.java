package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Car;
@Repository
public interface CarRepository extends CrudRepository<Car,Long> {
}
