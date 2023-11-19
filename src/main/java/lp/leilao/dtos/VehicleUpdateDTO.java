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
public class VehicleUpdateDTO implements Serializable {

    private String brand;

    private String manufactureYear;

    private String model;

    private String description;

    private String type;

    private String color;

    private Double initialValue;

    private String category;

    private Integer yearLicensing;

    private String resultPrecautionaryExpertise;

    private String tractionType;

    private Boolean sunroof = false;

    private Long productId;
}
