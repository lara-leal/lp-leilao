package lp.leilao.dtos.devices;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class RouterDTO {
    public String name;
    public Integer quantity;
    public String description;
    public String brand;
    public Boolean antenna;

    public RouterDTO() {
    }

    public RouterDTO(String name, Integer quantity, String description, String brand,
            Boolean antenna) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.brand = brand;
        this.antenna = antenna;
    }
}
