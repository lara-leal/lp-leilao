package lp.leilao.dtos.vehicles;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Data
@Introspected
@Serdeable
public class VehicleDTO {

    public Long id;
    public String brand;
    public String manufactureYear;
    public String model;
    public String description;
    public String color;
    public Double initialValue;
    public String category;
    private Integer yearLicensing;
    private String resultPrecautionaryExpertise;
    private String tractionType;
    private Boolean sunroof = false;
}
