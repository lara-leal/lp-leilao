package lp.leilao.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Introspected
@Serdeable
public class FinancialInstitutionDTO implements Serializable {

    private String cnpj;

    private String name;

    private String address;
}
