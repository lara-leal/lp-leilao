package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.ComputingDeviceDTO;
import lp.leilao.entities.devices.Router;
import lp.leilao.repositories.RouterRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class RouterService {
    @Inject
    private final RouterRepository routerRepository;

    public RouterService(RouterRepository routerRepository) {
        this.routerRepository = routerRepository;
    }

    public Iterable<ComputingDeviceDTO> getAllRouter() {
        return toComputingDeviceDTOList(routerRepository.findAll());
    }

    public ComputingDeviceDTO getRouterById(Long id) {
        return routerRepository.findById(id)
                .map(this::toComputingDeviceDTO)
                .orElse(null);
    }

    public ComputingDeviceDTO createRouter(Router router) {
        Router savedRouter = routerRepository.save(router);
        return toComputingDeviceDTO(savedRouter);
    }

    public void deleteRouter(Long id) {
        routerRepository.deleteById(id);
    }

    private ComputingDeviceDTO toComputingDeviceDTO(Router router) {
        ComputingDeviceDTO dto = new ComputingDeviceDTO();
        dto.setAntenna(router.getAntenna());
        return dto;
    }

    private Iterable<ComputingDeviceDTO> toComputingDeviceDTOList(Iterable<Router> routers) {
        List<ComputingDeviceDTO> dtos = new ArrayList<>();
        for (Router router : routers) {
            dtos.add(toComputingDeviceDTO(router));
        }
        return dtos;
    }
}
