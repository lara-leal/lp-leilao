package lp.leilao.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lp.leilao.entities.devices.ComputingDevice;
import lp.leilao.entities.vehicles.Vehicle;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long prod_id;

    public String name;
    public String description;
    public Double initialValue;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ComputingDevice> computingDevices;
}
