package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lp.leilao.entities.devices.ComputingDevice;
import lp.leilao.entities.vehicles.Vehicle;

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

    @JsonIgnore
    @OneToMany(mappedBy = "auction")
    private List<Product> products;

    @JsonIgnore
    @OneToMany(mappedBy = "auction")
    private List<ComputingDevice> computingDevice;

    @JsonIgnore
    @OneToMany(mappedBy = "auction")
    private List<Vehicle> vehicles;

    @JsonIgnore
    @OneToMany(mappedBy = "auction")
    private List<Bid> bids;

}
