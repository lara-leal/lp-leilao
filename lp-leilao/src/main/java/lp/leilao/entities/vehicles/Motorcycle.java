package lp.leilao.entities.vehicles;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@DiscriminatorValue("MOTORCYCLE")
public class Motorcycle extends Vehicle {
    public Motorcycle(Long id, String type, String brand, String manufactureYear, String model, String description, Double price, String color, Integer yearLicensing, String resultPrecautionaryExpertise, String fairingCondition) {
        super(id, type, brand, manufactureYear, model, description, price, color);

    }

    @Column(name = "yearLicensing")
    private Integer yearLicensing;
    @Column(name = "resultPrecautionaryExpertise")
    private String resultPrecautionaryExpertise;
    @Column(name = "fairingCondition")
    private String fairingCondition;
}
