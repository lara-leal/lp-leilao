package lp.leilao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micronaut.core.convert.format.Format;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;

    @Column(name = "numAuction")
    private Integer numAuction;

    @Column(name = "status")
    private String status;

    @Column(name = "occurrenceDate")
    private LocalDate occurrenceDate;

    @Column(name = "occurrenceHour")
    private LocalTime occurrenceHour;

    @Column(name = "visitDate")
    private LocalDate visitDate;

    @Column(name = "visitHour")
    private LocalTime visitHour;

    @Column(name = "address")
    private String address;

    @Column(name = "category")
    private String category;

    @OneToMany(mappedBy = "auction", fetch = FetchType.EAGER)
    private List<Bid> bids;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<FinancialInstitution> fInstitutions;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Product product;


}
