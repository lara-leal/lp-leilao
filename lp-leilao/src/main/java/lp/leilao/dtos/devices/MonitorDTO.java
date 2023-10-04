package lp.leilao.dtos.devices;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class MonitorDTO {
    public String name;
    public Integer quantity;
    public String description;
    public Double deviceValue;
    public String brand;
    private String screenSize;
    private String refreshRate;

    public MonitorDTO(){

    }
    public MonitorDTO(String name, Integer quantity, String description, Double deviceValue, String brand, String screenSize, String refreshRate) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.deviceValue = deviceValue;
        this.brand = brand;
        this.screenSize = screenSize;
        this.refreshRate = refreshRate;
    }
}
