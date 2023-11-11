package lp.leilao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.*;
import lp.leilao.entities.Auction;
import lp.leilao.entities.Product;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
@Table(name = "computingDevice")
@Inheritance(strategy = InheritanceType.JOINED)
public class ComputingDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "category")
    public String category;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @Column(name = "initialValue")
    public Double initialValue;

    @Column(name = "ports")
    private String ports;

    @Column(name = "specification")
    private String productSpecification;

    @Column(name = "screenSize")
    private String screenSize;

    @Column(name = "antenna")
    private Boolean antenna;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "prodId")
    private Product product;

}
