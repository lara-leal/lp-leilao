package lp.leilao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micronaut.core.convert.format.Format;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
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

    @Column(name = "FinishDate")
    private LocalDate finishDate;

    @Column(name = "FinishHour")
    private LocalTime finishHour;

    @Column(name = "visitDate")
    private LocalDate visitDate;

    @Column(name = "visitHour")
    private LocalTime visitHour;

    @Column(name = "address")
    private String address;

    @Column(name = "category")
    private String category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "auction_financial",
            joinColumns = @JoinColumn(name = "auctionId"),
            inverseJoinColumns = @JoinColumn(name = "fiid"))
    private List<FinancialInstitution> fInstitutions;

    @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    @JsonSerialize
    private Product product;


}
