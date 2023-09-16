package lp.leilao.entities;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Serdeable
@Table(name ="switch")
public class Switch extends DispositivoInformatica {
    @Column(name = "brand")
    private String brand;
    @Column(name = "ports")
    private String ports;
    @Column(name = "volts")
    private String volts;
}
