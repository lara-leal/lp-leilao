package lp.leilao.repositories;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Hub;
@Repository
public interface HubRepository extends CrudRepository<Hub, Long> {
}
