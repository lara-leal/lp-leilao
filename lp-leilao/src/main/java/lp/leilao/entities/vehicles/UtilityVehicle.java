package lp.leilao.entities.vehicles;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
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
@DiscriminatorValue("UTILITY-VEHICLE")
public class UtilityVehicle extends Vehicle {

    public UtilityVehicle(Long id, String type, String brand, String manufactureYear, String model, String description, Double price, String color, double groundClearance, String tractionType) {
        super(id, type, brand, manufactureYear, model, description, price, color);
    }

    @Column(name = "groundClearance")
    private double groundClearance;
    @Column(name = "tractionType")
    private String tractionType;


}
