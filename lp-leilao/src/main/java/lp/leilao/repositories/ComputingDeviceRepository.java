package lp.leilao.repositories;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.ComputingDevice;

import java.util.List;

@Repository
public interface ComputingDeviceRepository extends CrudRepository<ComputingDevice, Long> {

    List<ComputingDevice> findByCategory(String category);

}
