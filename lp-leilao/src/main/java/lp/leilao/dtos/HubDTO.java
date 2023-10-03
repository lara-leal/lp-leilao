package lp.leilao.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class HubDTO {

    public String name;
    public Integer quantity;
    public String description;
    public Double deviceValue;
    public String brand;
    public String ports;
    public String volts;

    public HubDTO() {
    }
    public HubDTO(String name, Integer quantity, String description, Double deviceValue, String brand, String ports, String volts) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.deviceValue = deviceValue;
        this.brand = brand;
        this.ports = ports;
        this.volts = volts;
    }
}
