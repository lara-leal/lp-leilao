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

    public void deleteRouter(Long id) {
        routerRepository.deleteById(id);
    }

    private RouterDTO toRouterDTO(Router router) {
        RouterDTO dto = new RouterDTO();
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
