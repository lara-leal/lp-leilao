package lp.leilao.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Introspected
@Serdeable
public class BidUpdateWinnerDTO {

    private Boolean winner;

    private ClientDTO client;
}
