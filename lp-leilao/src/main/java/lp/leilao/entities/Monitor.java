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
@Table(name ="monitor")
public class Monitor extends DispositivoInformatica {
    @Column(name = "screenSize")
    private String screenSize;

    @Column(name = "refreshRate")
    private String refreshRate;

}