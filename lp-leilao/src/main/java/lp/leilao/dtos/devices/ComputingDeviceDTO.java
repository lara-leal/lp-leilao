package lp.leilao.dtos.devices;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.annotation.Get;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lp.leilao.dtos.BidDTO;
import lp.leilao.entities.Bid;
import lp.leilao.entities.ComputingDevice;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Introspected
@Serdeable
public class ComputingDeviceDTO implements Serializable {
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
    private List<BidDTO> bids;

}