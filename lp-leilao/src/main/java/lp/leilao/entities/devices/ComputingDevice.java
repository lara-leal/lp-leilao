package lp.leilao.entities.devices;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "computing_device")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ComputingDevice {
    @Hidden
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "brand")
    private String brand;

}
