package lp.leilao.services.vehicles;

import jakarta.inject.Singleton;

@Singleton
public class TruckService {

//    private final TruckRepository truckRepository;
//    private final AuctionService auctionService;
//
//    @Inject
//    public TruckService(TruckRepository truckRepository, AuctionService auctionService) {
//        this.truckRepository = truckRepository;
//        this.auctionService = auctionService;
//    }
//
//    public List<Truck> getAllTruck() {
//        try {
//            List<Truck> hubs = truckRepository.findAll();
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
//    public Truck getTruckById(Long id) {
//        try {
//            return truckRepository.findById(id).orElseThrow(NoResultsFound::new);
//        } catch (NoResultsFound e) {
//            throw new NoResultsFound();
//        }
//
//    }
//
//    public void createTruck(Truck hub) {
//        try{
//            Auction auction = auctionService.getAuctionById(null);
//            if (auction.equals(null)){
//                throw new NoAuctionFoundException();
//            }
//            truckRepository.save(hub);
//        }catch (RuntimeException e) {
//            throw new NoAuctionFoundException();
//        }
//    }
//
//    public void updateTruck(Long id, Truck truck) {
//        try {
//            Truck existingHub = getTruckById(id);
//            Truck updateHub = updateMapper(existingHub, truck);
//
//            truckRepository.update(updateHub);
//        } catch (RuntimeException e) {
//            throw new NoResultsFound();
//        }
//    }
//
//    public void deleteTruck(Long id) {
//        try{
//            truckRepository.deleteById(id);
//        }catch (FailDeleteException e){
//            throw new RuntimeException() ;
//        }
//    }
//
//    private Truck updateMapper(Truck existingTruck, Truck truck) {
//        try {
//
//            return existingTruck;
//        }catch (RuntimeException e){
//            throw new UpdateObjectException();
//        }
//
//    }
}
