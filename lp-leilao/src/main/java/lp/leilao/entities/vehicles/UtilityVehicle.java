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
public class UtilityVehicle extends Vehicle {

    @Column(name = "groundClearance")
    private Double groundClearance;
    @Column(name = "tractionType")
    private String tractionType;


}
