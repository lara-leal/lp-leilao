package lp.leilao.entities.devices;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lp.leilao.entities.Product;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Serdeable
@Table(name = "computing_device")
@Inheritance(strategy = InheritanceType.JOINED)
public class ComputingDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prod_id")
    private Product product;

}
