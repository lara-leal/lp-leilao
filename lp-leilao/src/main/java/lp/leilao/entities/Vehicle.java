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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "initialValue")
    public Double initialValue;

    @Column(name = "category")
    public String category;

    @Column(name = "yearLicensing")
    private Integer yearLicensing;

    @Column(name = "resultPrecautionaryExpertise")
    private String resultPrecautionaryExpertise;

    @Column(name = "tractionType")
    private String tractionType;

    @Column(name = "sunroof")
    private Boolean sunroof = false;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "prodId")
    private Product product;

    @JsonManagedReference
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Bid> bid;


}
