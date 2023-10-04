package lp.leilao.repositories.devices;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.devices.Hub;

@Repository
public interface HubRepository extends CrudRepository<Hub, Long> {
}