package lp.leilao.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;
import lp.leilao.dtos.devices.ComputingDeviceDTO;
import lp.leilao.dtos.vehicles.VehicleDTO;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Introspected
@Serdeable
public class ProductDTO implements Serializable {

    private List<ComputingDeviceDTO> devices;


    private List<VehicleDTO> vehicles;
}
