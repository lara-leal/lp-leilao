package lp.leilao.entities.devices;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Serdeable
@DiscriminatorValue("ROTEADOR")
public class Roteador extends DispositivoInformatica {
    @Column(name = "antenna")
    private Boolean antenna;
}
