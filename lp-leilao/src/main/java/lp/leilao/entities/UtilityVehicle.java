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
@Table(name ="utility_vehicle")
public class UtilityVehicle extends Vehicle{

    @Column(name = "groundClearance")
    private double groundClearance;
    @Column(name = "color")
    private String color;
    @Column(name = "tractionType")
    private String tractionType;


}
