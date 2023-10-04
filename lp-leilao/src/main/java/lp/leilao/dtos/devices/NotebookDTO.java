package lp.leilao.dtos.devices;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lp.leilao.entities.devices.ComputingDevice;
import lp.leilao.entities.devices.Notebook;
@Data
@Introspected
@Serdeable
public class NotebookDTO {
    public String name;
    public Integer quantity;
    public String description;
    public Double deviceValue;
    public String brand;
    public String specification;


    public NotebookDTO() {
    }

    public NotebookDTO(String name, Integer quantity, String description, Double deviceValue, String brand, String specification) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.deviceValue = deviceValue;
        this.brand = brand;
        this.specification = specification;
    }
}
