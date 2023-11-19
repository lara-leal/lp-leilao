package lp.leilao.dtos.vehicles;

import io.micronaut.core.annotation.Introspected;

import io.micronaut.serde.annotation.Serdeable;

import lombok.Getter;
import lombok.Setter;
import lp.leilao.dtos.BidDTO;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Introspected
@Serdeable
public class VehicleDTO implements Serializable {
    private Long id;
    private String brand;
    private String manufactureYear;
    private String model;
    private String description;
    private String color;
    private Double initialValue;
    private String category;
    private Integer yearLicensing;
    private String resultPrecautionaryExpertise;
    private String tractionType;
    private Boolean sunroof = false;
    private Long productId;
    private List<BidDTO> bids;
}
