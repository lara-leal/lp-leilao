package lp.leilao.services.devices;

import jakarta.inject.Singleton;

@Singleton
public class RouterService {

//    private final RouterRepository routerRepository;
//    private final AuctionService auctionService;
//
//    @Inject
//    public RouterService(RouterRepository routerRepository, AuctionService auctionService) {
//        this.routerRepository = routerRepository;
//        this.auctionService = auctionService;
//    }
//
//    public List<Router> getAllRouter() {
//        try {
//            List<Router> routers = routerRepository.findAll();
//            if (routers.isEmpty()){
//                throw new NoResultsFound();
//            }
//            return routers;
//        }catch (NoResultsFound e){
//            throw new NoResultsFound();
//        }
//    }
//
//    public Router getRouterById(Long id) {
//        try {
//            return routerRepository.findById(id)
//                    .orElseThrow(NoResultsFound::new);
//        }catch (NoResultsFound e){
//            throw new NoResultsFound();
//        }
//
//    }
//
//    public void createRouter(Router router) {
//        try {
//            auctionService.getAuctionById(null);
//            routerRepository.save(router);
//        }catch (NoAuctionFoundException e){
//            throw new NoAuctionFoundException();
//        }
//
//    }
//
//    public void updateRouter(Long id, Router updateRouter) {
//        try {
//            Router existingRouter = routerRepository.findById(id)
//                    .orElseThrow(NoResultsFound::new);
//
//            updateMapper(existingRouter, updateRouter);
//        }catch (NoResultsFound e){
//            throw new NoResultsFound();
//        }
//    }
//
//    public void deleteRouter(Long id) {
//        try{
//            routerRepository.deleteById(id);
//        }catch (FailDeleteException e){
//            throw new RuntimeException() ;
//        }
//
//    }
//
//    private Router updateMapper(Router existingRouter, Router router) {
//        try {
//            existingRouter.setBrand(router.getBrand() != null ? router.getBrand() : existingRouter.getBrand());
//            existingRouter.setAntenna(router.getAntenna() != null ? router.getAntenna()  : existingRouter.getAntenna());
//            existingRouter.setQuantity(router.getQuantity() != null ? router.getQuantity() : existingRouter.getQuantity());
//
//            return existingRouter;
//        }catch (RuntimeException e){
//            throw new UpdateObjectException();
//        }
//
//    }
}
