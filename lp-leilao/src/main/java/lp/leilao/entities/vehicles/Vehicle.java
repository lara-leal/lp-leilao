package lp.leilao.entities.vehicles;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
@Table(name ="vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
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
    @Column(name = "price")
    public Double price;
    @Column(name= "color")
    public String color;

}
