package lp.leilao.entities.vehicles;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lp.leilao.entities.vehicles.Vehicle;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@DiscriminatorValue("CAR")
public class Car extends Vehicle {

    public Car(Long id, String type, String brand, String manufactureYear, String model, String description, Double price, String color, Boolean sunroof, Integer yearLicensing, String resultPrecautionaryExpertise) {
        super(id, type, brand, manufactureYear, model, description, price, color);
    }

    @Column(name = "sunroof")
    private Boolean sunroof;
    @Column(name = "yearLicensing")
    private Integer yearLicensing;
    @Column(name = "resultPrecautionaryExpertise")
    private String resultPrecautionaryExpertise;

}
