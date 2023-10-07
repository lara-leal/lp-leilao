package lp.leilao.dtos.vehicles;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Introspected
@Serdeable

public class CarDTO {
    public String brand;
    public String manufactureYear;
    public String model;
    public String description;
    public String color;
    public Boolean sunroof;
    public Integer yearLicensing;
    public String resultPrecautionaryExpertise;

    public CarDTO() {

    }

    public CarDTO(String brand, String manufactureYear, String model, String description, String color,
            Boolean sunroof, Integer yearLicensing, String resultPrecautionaryExpertise) {
        this.brand = brand;
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.description = description;
        this.color = color;
        this.sunroof = sunroof;
        this.yearLicensing = yearLicensing;
        this.resultPrecautionaryExpertise = resultPrecautionaryExpertise;
    }
}
