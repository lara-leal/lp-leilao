package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name ="auction")
public class Auction {
    @Id
    private Long auction_id;
    @Column(name = "numAuction")
    private Integer numAuction;
    @Column(name = "financialInstitution")
    private String  financialInstitution;
    @Column(name = "initialDate")
    private Date initialDate;
    @Column(name = "finalDate")
    private Date finalDate;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FinancialInstitution> financialInstitutions;

    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<Product> products;

    @ManyToMany(mappedBy = "authorizedAuctions")
    private Set<Client> authorizedClient;
}

