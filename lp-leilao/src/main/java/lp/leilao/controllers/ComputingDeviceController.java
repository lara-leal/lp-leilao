package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.devices.ComputingDevice;
import lp.leilao.services.ComputingDeviceService;

@Controller("/devices")
public class ComputingDeviceController {

    @Inject
    private final ComputingDeviceService deviceService;

    public ComputingDeviceController(ComputingDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Get("/list")
    public Iterable<ComputingDevice> listDevices() {
        return deviceService.getAllDevice();
    }

    @Get("/{id}")
    public ComputingDevice getDevice(Long id) {

        return deviceService.getDeviceById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public ComputingDevice createDevice(@Body @Valid ComputingDevice device) {
        return deviceService.createDevice(device);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteDevice(Long id) {
        deviceService.deleteDevice(id);
    }
}
