package lp.leilao.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name = "bid")
public class Bid{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bidId;

    @Column(name = "bidValue")
    private Double bidValue;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "bidCategory", nullable = false)
    private String bidCategory;

    @Column(name = "winner")
    private Boolean winner = false;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JoinColumn(name="deviceId")
    private ComputingDevice device;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JoinColumn(name="vehicleId")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "clientId")
    private Client client;

}
