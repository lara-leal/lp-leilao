package lp.leilao.dtos.devices;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class SwitchDTO {
    public String name;
    public Integer quantity;
    public String description;
    public String brand;
    public Integer numberOfPorts;
    public String firmwareVersion;

    public SwitchDTO() {

    }

    public SwitchDTO(String name, Integer quantity, String description, String brand,
            Integer numberOfPorts, String firmwareVersion) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.brand = brand;
        this.numberOfPorts = numberOfPorts;
        this.firmwareVersion = firmwareVersion;
    }
}
