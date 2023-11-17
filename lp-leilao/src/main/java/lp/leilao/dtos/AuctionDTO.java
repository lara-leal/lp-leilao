package lp.leilao.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lp.leilao.entities.FinancialInstitution;
import lp.leilao.entities.Product;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Introspected
@Serdeable
public class AuctionDTO implements Serializable {

    private Integer numAuction;

    private String status;

    private LocalDate occurrenceDate;

    private LocalTime occurrenceHour;

    private LocalDate visitDate;

    private LocalTime visitHour;

    private String address;

    private String category;

    private List<FinancialInstitutionDTO> fInstitutions;

    private ProductDTO product;
}
