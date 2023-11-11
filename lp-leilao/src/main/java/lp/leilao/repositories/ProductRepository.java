package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import lp.leilao.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
