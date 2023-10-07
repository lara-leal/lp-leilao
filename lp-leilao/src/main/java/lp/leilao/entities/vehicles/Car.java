package lp.leilao.entities.vehicles;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
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
public class Car extends Vehicle {

    @Column(name = "sunroof")
    private Boolean sunroof;
    @Column(name = "yearLicensing")
    private Integer yearLicensing;
    @Column(name = "resultPrecautionaryExpertise")
    private String resultPrecautionaryExpertise;

}
