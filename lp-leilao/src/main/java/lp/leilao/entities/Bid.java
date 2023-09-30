package lp.leilao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bid {
    @Id
    public Long id;
    public Double value;
    public Date data;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
}
