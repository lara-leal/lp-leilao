package lp.leilao.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name = "financialInstitution")
public class FinancialInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fiid;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToMany(mappedBy = "fInstitutions", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Auction> auction;

}
