package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

}
