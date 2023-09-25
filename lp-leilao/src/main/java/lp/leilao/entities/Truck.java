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
@Table(name ="truck")
public class Truck extends Vehicle{

    @Column(name = "cargoCapacity")
    private double cargoCapacity;
    @Column(name = "engineType")
    private String engineType;
    @Column(name = "color")
    private String color;

}
