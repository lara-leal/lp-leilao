package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name ="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "brand")
    private String brand;
    @Column(name = "manufactureYear")
    private String manufactureYear;
    @Column(name = "model")
    private String model;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

}
