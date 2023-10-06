package lp.leilao.dtos.devices;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class HubDTO {
    public Long id;

    public String name;
    public Integer quantity;
    public String description;
    public Double deviceValue;
    public String brand;
    public String ports;
    public String volts;

    public HubDTO() {
    }
    public HubDTO( Long id, String name, Integer quantity, String description, Double deviceValue, String brand, String ports, String volts) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.deviceValue = deviceValue;
        this.brand = brand;
        this.ports = ports;
        this.volts = volts;
    }
}
