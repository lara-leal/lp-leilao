package lp.leilao.dtos.vehicles;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class MotorcycleDTO {
    public String brand;
    public String manufactureYear;
    public String model;
    public String description;
    public Double price;
    public String color;
    public Integer yearLicensing;
    public String resultPrecautionaryExpertise;
    public String fairingCondition;

    public MotorcycleDTO(){

    }

    public MotorcycleDTO(String brand, String manufactureYear, String model, String description, Double price, String color, Integer yearLicensing, String resultPrecautionaryExpertise, String fairingCondition) {
        this.brand = brand;
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.description = description;
        this.price = price;
        this.color = color;
        this.yearLicensing = yearLicensing;
        this.resultPrecautionaryExpertise = resultPrecautionaryExpertise;
        this.fairingCondition = fairingCondition;
    }
}
