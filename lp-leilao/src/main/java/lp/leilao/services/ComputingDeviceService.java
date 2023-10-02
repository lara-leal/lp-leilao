package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.devices.ComputingDevice;
import lp.leilao.repositories.ComputingDeviceRepository;

@Singleton
public class ComputingDeviceService {
    @Inject
    private final ComputingDeviceRepository deviceRepository;

    public ComputingDeviceService(ComputingDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Iterable<ComputingDevice> getAllDevice() {
        return deviceRepository.findAll();
    }

    public ComputingDevice getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public ComputingDevice createDevice(ComputingDevice device) {

        return deviceRepository.save(device);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
