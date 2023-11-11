package lp.leilao.dtos.devices;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import lombok.Data;
import lp.leilao.entities.ComputingDevice;

@Data
@Introspected
@Serdeable
public class ComputingDeviceDTO {
    private String name;
    private Integer quantity;
    public String category;
    private String description;
    private String brand;
    public Double initialValue;
    private String ports;
    private String productSpecification;
    private String screenSize;
    private Boolean antenna;

}