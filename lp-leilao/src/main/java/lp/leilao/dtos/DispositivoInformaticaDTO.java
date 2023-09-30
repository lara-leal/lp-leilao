package lp.leilao.dtos;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lp.leilao.entities.devices.DispositivoInformatica;

@Data
@Introspected
@Serdeable
public class DispositivoInformaticaDTO {
    public DispositivoInformatica name;
    public DispositivoInformatica quantity;
    public DispositivoInformatica description;
    public DispositivoInformatica deviceValue;
    public DispositivoInformatica brand;
    public String ports;
    public String volts;
    public String specification;
    public Boolean antenna;
    public String screenSize;
    public String refreshRate;
    public Integer numberOfPorts;
    public String firmwareVersion;

    public DispositivoInformaticaDTO() {
    }

    public DispositivoInformaticaDTO(DispositivoInformatica name, DispositivoInformatica quantity, DispositivoInformatica description, DispositivoInformatica deviceValue, DispositivoInformatica brand, String ports, String volts, String specification, Boolean antenna, String screenSize, String refreshRate, Integer numberOfPorts, String firmwareVersion) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.deviceValue = deviceValue;
        this.brand = brand;
        this.ports = ports;
        this.volts = volts;
        this.specification = specification;
        this.antenna = antenna;
        this.screenSize = screenSize;
        this.refreshRate = refreshRate;
        this.numberOfPorts = numberOfPorts;
        this.firmwareVersion = firmwareVersion;
    }
}