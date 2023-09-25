package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name ="car")
public class Car extends Vehicle {
    @Column(name = "sunroof")
    private Boolean sunroof;
    @Column(name = "color")
    private String color;
    @Column(name = "yearLicensing")
    private Integer yearLicensing;
    @Column(name = "resultPrecautionaryExpertise")
    private String resultPrecautionaryExpertise;

}
