package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name = "financial_instituition")
public class FinancialInstitution {
    @Id
    private Long id;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

}
