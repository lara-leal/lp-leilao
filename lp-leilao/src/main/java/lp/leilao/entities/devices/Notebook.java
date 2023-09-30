package lp.leilao.entities.devices;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
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
@DiscriminatorValue("NOTEBOOK")
public class Notebook extends DispositivoInformatica {

    @Column(name = "specification")
    private String specification;

}
