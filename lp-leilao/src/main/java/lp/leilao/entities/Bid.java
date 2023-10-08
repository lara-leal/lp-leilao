package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.Hidden;
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
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long bid_id;
    public Double bid_value;
    public Date data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client")
    private Client clients;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auction_id")
    private Auction auction;
}
