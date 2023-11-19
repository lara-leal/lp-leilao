package lp.leilao.entities;

import com.fasterxml.jackson.annotation.*;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.*;
import lp.leilao.entities.Auction;
import lp.leilao.entities.Product;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "manufactureYear")
    private String manufactureYear;

    @Column(name = "model")
    private String model;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "color")
    private String color;

    @Column(name = "initialValue")
    private Double initialValue;

    @Column(name = "category")
    private String category;

    @Column(name = "yearLicensing")
    private Integer yearLicensing;

    @Column(name = "resultPrecautionaryExpertise")
    private String resultPrecautionaryExpertise;

    @Column(name = "tractionType")
    private String tractionType;

    @Column(name = "sunroof")
    private Boolean sunroof = false;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "prodId")
    private Product product;

    @JsonManagedReference
    @OneToMany(mappedBy = "vehicle",  fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Bid> bid;


}
