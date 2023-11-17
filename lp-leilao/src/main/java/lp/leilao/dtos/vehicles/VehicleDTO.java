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
    private List<BidDTO> bids;
}
