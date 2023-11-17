package lp.leilao.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE, CascadeType.DETACH}, orphanRemoval = true)
    @JsonSerialize
    private List<ComputingDevice> devices;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE ,CascadeType.DETACH}, orphanRemoval = true)
    @JsonSerialize
    private List<Vehicle> vehicles;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private Auction auction;



}
