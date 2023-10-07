package lp.leilao.entities.devices;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
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
@Introspected
@Serdeable
public class Hub extends ComputingDevice {
    @Column(name = "ports")
    private String ports;
    @Column(name = "volts")
    private String volts;
}
