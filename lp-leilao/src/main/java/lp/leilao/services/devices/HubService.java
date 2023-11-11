package lp.leilao.services.devices;

import jakarta.inject.Singleton;

@Singleton
public class HubService {

//    private final HubRepository hubRepository;
//
//    private final AuctionService auctionService;
//
//    @Inject
//    public HubService(HubRepository hubRepository, AuctionService auctionService) {
//        this.hubRepository = hubRepository;
//        this.auctionService = auctionService;
//    }
//
//
//    public List<Hub> getAllHubs() {
//        try {
//            List<Hub> hubs = hubRepository.findAll();
//            if (hubs.isEmpty()){
//                throw new NoResultsFound();
//            }
//
//            return hubs;
//        }catch (RuntimeException e){
//            throw new NoResultsFound();
//        }
//    }
//
//    public Hub getHubById(Long id) {
//        try {
//            return hubRepository.findById(id).orElseThrow(NoResultsFound::new);
//        } catch (NoResultsFound e) {
//            throw new NoResultsFound();
//        }
//
//    }
//
//    public void createHub(Hub hub) {
//        try{
//            Auction auction = auctionService.getAuctionById(null);
//            if (auction.equals(null)){
//                throw new NoAuctionFoundException();
//            }
//            hubRepository.save(hub);
//        }catch (RuntimeException e) {
//            throw new NoAuctionFoundException();
//        }
//    }
//
//    public void updateHub(Long id, Hub hub) {
//        try {
//            Hub existingHub = getHubById(id);
//            Hub updateHub = updateMapper(existingHub, hub);
//
//            hubRepository.update(updateHub);
//        } catch (RuntimeException e) {
//            throw new NoResultsFound();
//        }
//    }
//
//    public void deleteHub(Long id) {
//        try{
//            hubRepository.deleteById(id);
//        }catch (FailDeleteException e){
//            throw new RuntimeException() ;
//        }
//    }
//
//    private Hub updateMapper(Hub existingHub, Hub hub) {
//        try {
//            existingHub.setPorts(hub.getPorts() != null ? hub.getPorts() : existingHub.getPorts());
//            existingHub.setVolts(hub.getVolts() != null ? hub.getVolts()  :existingHub.getVolts());
//            existingHub.setBrand(hub.getBrand() != null ? hub.getBrand() :existingHub.getBrand());
//            existingHub.setQuantity(hub.getQuantity() != null ? hub.getQuantity() :existingHub.getQuantity());
//            existingHub.setName(hub.getName() != null ? hub.getName() :existingHub.getName());
//            existingHub.setDescription(hub.getDescription() != null ? hub.getDescription() :existingHub.getDescription());
//            existingHub.setInitialValue(hub.getInitialValue() != null ? hub.getInitialValue() :existingHub.getInitialValue());
//
//            return existingHub;
//        }catch (RuntimeException e){
//            throw new UpdateObjectException();
//        }
//
//    }

}
