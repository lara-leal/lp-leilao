package lp.leilao.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lp.leilao.entities.Client;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.entities.Vehicle;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Introspected
@Serdeable
public class BidDTO implements Serializable {

    private Double bidValue;

    private LocalDateTime date;

    private String bidCategory;

    private Long productIdSale;

    private Boolean winner = false;

    private ClientDTO client;
}
