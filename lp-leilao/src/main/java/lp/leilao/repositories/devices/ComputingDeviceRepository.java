package lp.leilao.repositories.devices;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.devices.ComputingDevice;

@Repository
public interface ComputingDeviceRepository extends CrudRepository<ComputingDevice, Long> {
}
