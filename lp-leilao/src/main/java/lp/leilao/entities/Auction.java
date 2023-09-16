package lp.leilao.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name ="auction")
public class Auction {
    @Id
    private Long id;
    @Column(name = "numAuction")
    private Integer numAuction;
    @Column(name = "batchProducts")
    private Integer batchProducts;
    @Column(name = "financialInstitution")
    private String  financialInstitution;
    @Column(name = "data")
    private Date data;
    @Column(name = "address")
    private String address;
}
