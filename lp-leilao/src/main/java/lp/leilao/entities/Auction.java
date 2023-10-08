package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auction_id;
    @Column(name = "numAuction")
    private Integer numAuction;
    @Column(name = "financialInstitution")
    private String financialInstitution;
    @Column(name = "initialDate")
    private Date initialDate;
    @Column(name = "finalDate")
    private Date finalDate;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "auction", fetch = FetchType.EAGER)
    private List<Product> products;

    @JsonIgnore
    @OneToMany(mappedBy = "auction", fetch = FetchType.EAGER)
    private List<Bid> bids;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "financialInstitution_auction", joinColumns = @JoinColumn(name = "auction_id"), inverseJoinColumns = @JoinColumn(name = "fi_id"))
    private List<FinancialInstitution> fInstitutions;

}
