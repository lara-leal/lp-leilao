package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Roteador;
@Repository
public interface RoteadorRepository  extends CrudRepository<Roteador, Long> {
}
