package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.DispositivoInformatica;

@Repository
public interface DispositivoInformaticaRepository extends CrudRepository<DispositivoInformatica, Long> {
}
