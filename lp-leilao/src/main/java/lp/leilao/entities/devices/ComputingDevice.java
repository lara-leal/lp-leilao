package lp.leilao.entities.devices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.micronaut.context.annotation.Type;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "computing_device")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ComputingDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "device_value")
    private Double deviceValue;

    @Column(name = "brand")
    private String brand;


}
