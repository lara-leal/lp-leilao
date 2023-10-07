package lp.leilao.dtos.vehicles;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class TruckDTO {
    public String brand;
    public String manufactureYear;
    public String model;
    public String description;
    public String color;
    public Double cargoCapacity;
    public String engineType;

    public TruckDTO() {

    }

    public TruckDTO(String brand, String manufactureYear, String model, String description, String color,
            Double cargoCapacity, String engineType) {
        this.brand = brand;
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.description = description;
        this.color = color;
        this.cargoCapacity = cargoCapacity;
        this.engineType = engineType;
    }
}
