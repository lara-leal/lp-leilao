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
@DiscriminatorValue("TRUCK")
public class Truck extends Vehicle {

    public Truck(Long id, String type, String brand, String manufactureYear, String model, String description, Double price, String color, double cargoCapacity, String engineType) {
        super(id, type, brand, manufactureYear, model, description, price, color);
    }

    @Column(name = "cargoCapacity")
    private double cargoCapacity;
    @Column(name = "engineType")
    private String engineType;
}
