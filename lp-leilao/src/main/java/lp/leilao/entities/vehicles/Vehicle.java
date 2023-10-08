package lp.leilao.entities.vehicles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lp.leilao.entities.Auction;
import lp.leilao.entities.Product;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
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

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_id")
    private Product product;

}
