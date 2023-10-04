package lp.leilao.repositories.devices;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.devices.Notebook;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Long> {
}
