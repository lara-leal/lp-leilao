package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Notebook;
@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> {
}
