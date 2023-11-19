package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.dtos.ComputingDeviceUpdateDTO;
import lp.leilao.dtos.devices.ComputingDeviceDTO;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.services.devices.ComputingDeviceService;

import java.util.List;

@Controller("/devices")
@Tag(name = "Devices")
public class ComputingDeviceController {

    private final ComputingDeviceService computingDeviceService;

    @Inject
    public ComputingDeviceController(ComputingDeviceService computingDeviceService) {
        this.computingDeviceService = computingDeviceService;
    }

    @Post("/register-device")
    public HttpResponse<?> registerDevice(@Body @Valid ComputingDeviceUpdateDTO computingDevice) {
        computingDeviceService.registerDevice(computingDevice);
        return HttpResponse.created("Device successfully register");
    }

    @Get("available-devices")
    public HttpResponse<List<ComputingDeviceDTO>> findAllDevices(){
        return HttpResponse.ok().body(computingDeviceService.findAllDevices());
    }

    @Get("/find-by-category/{category}")
    public HttpResponse<List<ComputingDeviceDTO>> findByCategory(String category){
        return HttpResponse.ok().body(computingDeviceService.findDeviceByCategory(category));
    }

    @Put("/update-device/{id}")
    public HttpResponse<?> updateDevice(Long id, ComputingDeviceUpdateDTO device){
        computingDeviceService.updateDevice(id, device);
        return HttpResponse.ok("Update with successful");
    }

    @Delete("/delete-device/{id}")
    public HttpResponse<?> deleteDeviceById(Long id){
        computingDeviceService.deleteDevice(id);
        return HttpResponse.ok("Deleted with successful");
    }
}
