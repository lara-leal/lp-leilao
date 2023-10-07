package lp.leilao.dtos.vehicles;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class UtilityVehicleDTO {
    public String brand;
    public String manufactureYear;
    public String model;
    public String description;
    public String color;
    public Double groundClearance;
    public String tractionType;

    public UtilityVehicleDTO() {

    }

    public UtilityVehicleDTO(String brand, String manufactureYear, String model, String description,
            String color, Double groundClearance, String tractionType) {
        this.brand = brand;
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.description = description;
        this.color = color;
        this.groundClearance = groundClearance;
        this.tractionType = tractionType;
    }
}
