package lp.leilao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="bid")
public class Bid {
    @Id
    public Long id;
    public Double value;
    public Date data;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
}
