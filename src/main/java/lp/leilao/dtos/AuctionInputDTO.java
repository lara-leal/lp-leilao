package lp.leilao.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;
import lp.leilao.entities.Product;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Introspected
@Serdeable
public class AuctionInputDTO implements Serializable {

    private Integer numAuction;

    private String status;

    private LocalDateTime occurrenceDate;

    private LocalDateTime finishDate;

    private LocalDateTime visitDate;

    private String address;

    private String category;

    private List<FinancialInstitutionInputDTO> fInstitutions;

    private ProductDTOInput product;

}
