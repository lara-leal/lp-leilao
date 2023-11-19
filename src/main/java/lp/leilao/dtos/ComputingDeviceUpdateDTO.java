package lp.leilao.dtos;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Introspected
@Serdeable
public class ComputingDeviceUpdateDTO implements Serializable {

    private String name;

    private Integer quantity;

    private String category;

    private String type;

    private String description;

    private String brand;

    public Double initialValue;

    private String ports;

    private String productSpecification;

    private String screenSize;

    private Boolean antenna;

    private Long productId;
}
