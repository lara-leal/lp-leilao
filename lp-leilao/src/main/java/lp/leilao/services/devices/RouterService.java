package lp.leilao.services.devices;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.dtos.devices.RouterDTO;
import lp.leilao.entities.devices.Router;
import lp.leilao.repositories.devices.RouterRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class RouterService {
    @Inject
    private final RouterRepository routerRepository;

    public RouterService(RouterRepository routerRepository) {
        this.routerRepository = routerRepository;
    }

    public Iterable<RouterDTO> getAllRouter() {
        return toRouterDTOList(routerRepository.findAll());
    }

    public RouterDTO getRouterById(Long id) {
        return routerRepository.findById(id)
                .map(this::toRouterDTO)
                .orElse(null);
    }

    public RouterDTO createRouter(Router router) {
        Router savedRouter = routerRepository.save(router);
        return toRouterDTO(savedRouter);
    }

    public RouterDTO updateRouter(Long id, RouterDTO updatedRouterDTO) {
        Router existingRouter = routerRepository.findById(id).orElse(null);
        if (existingRouter != null) {
            existingRouter.setName(updatedRouterDTO.getName());
            existingRouter.setQuantity(updatedRouterDTO.getQuantity());
            existingRouter.setBrand(updatedRouterDTO.getBrand());
            existingRouter.setAntenna(updatedRouterDTO.getAntenna());

            Router updatedRouter = routerRepository.update(existingRouter);
            return toRouterDTO(updatedRouter);
        }
        return null;
    }

    public void deleteRouter(Long id) {
        routerRepository.deleteById(id);
    }

    private RouterDTO toRouterDTO(Router router) {
        RouterDTO dto = new RouterDTO();
        dto.setName(router.getName());
        dto.setQuantity(router.getQuantity());
        dto.setBrand(router.getBrand());
        dto.setAntenna(router.getAntenna());
        return dto;
    }

    private Iterable<RouterDTO> toRouterDTOList(Iterable<Router> routers) {
        List<RouterDTO> dtos = new ArrayList<>();
        for (Router router : routers) {
            dtos.add(toRouterDTO(router));
        }
        return dtos;
    }
}
