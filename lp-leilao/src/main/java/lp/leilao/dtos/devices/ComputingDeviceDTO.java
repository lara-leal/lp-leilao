package lp.leilao.dtos.devices;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lp.leilao.entities.devices.ComputingDevice;

@Data
@Introspected
@Serdeable
public class ComputingDeviceDTO {
    public ComputingDevice name;
    public ComputingDevice quantity;
    public ComputingDevice description;
    public ComputingDevice brand;
    public String ports;
    public String volts;
    public String specification;
    public Boolean antenna;
    public String screenSize;
    public String refreshRate;
    public Integer numberOfPorts;
    public String firmwareVersion;

    public ComputingDeviceDTO() {
    }

    public ComputingDeviceDTO(ComputingDevice name, ComputingDevice quantity, ComputingDevice description,
            ComputingDevice brand, String ports, String volts, String specification,
            Boolean antenna, String screenSize, String refreshRate, Integer numberOfPorts, String firmwareVersion) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
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