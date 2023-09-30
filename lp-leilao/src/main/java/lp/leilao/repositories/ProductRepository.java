package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
