package lp.leilao.entities.vehicles;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "brand")
    public String brand;
    @Column(name = "manufactureYear")
    public String manufactureYear;
    @Column(name = "model")
    public String model;
    @Column(name = "description")
    public String description;
    @Column(name = "color")
    public String color;

}
