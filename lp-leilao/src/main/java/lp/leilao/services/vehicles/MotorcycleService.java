package lp.leilao.services.vehicles;

import jakarta.inject.Singleton;

@Singleton
public class MotorcycleService {

//    private final MotorcycleRepository motorcycleRepository;
//    private final AuctionService auctionService;
//
//    public MotorcycleService(MotorcycleRepository motorcycleRepository, AuctionService auctionService) {
//        this.motorcycleRepository = motorcycleRepository;
//        this.auctionService = auctionService;
//    }
//
//    public List<Motorcycle> getAllMotorcycle() {
//        try {
//            List<Motorcycle> motorcycles = motorcycleRepository.findAll();
//            if (motorcycles.isEmpty()){
//                throw new NoResultsFound();
//            }
//
//            return motorcycles;
//        }catch (RuntimeException e){
//            throw new NoResultsFound();
//        }
//    }
//
//    public Motorcycle getMotorcycleById(Long id) {
//        try {
//            return motorcycleRepository.findById(id).orElseThrow(NoResultsFound::new);
//        } catch (NoResultsFound e) {
//            throw new NoResultsFound();
//        }
//
//    }
//
//    public void createMotorcycle(Motorcycle motorcycle) {
//        try{
//            Auction auction = auctionService.getAuctionById(null);
//            if (auction.equals(null)){
//                throw new NoAuctionFoundException();
//            }
//            motorcycleRepository.save(motorcycle);
//        }catch (RuntimeException e) {
//            throw new NoAuctionFoundException();
//        }
//    }
//
//    public void updateMotorcycle(Long id, Motorcycle motorcycle) {
//        try {
//            Motorcycle existingMotorcycle = getMotorcycleById(id);
//            Motorcycle updateMotorcycle = updateMapper(existingMotorcycle, motorcycle);
//
//            motorcycleRepository.update(updateMotorcycle);
//        } catch (RuntimeException e) {
//            throw new NoResultsFound();
//        }
//    }
//
//    public void deleteMotorcycle(Long id) {
//        try{
//            motorcycleRepository.deleteById(id);
//        }catch (FailDeleteException e){
//            throw new RuntimeException() ;
//        }
//    }
//
//    private Motorcycle updateMapper(Motorcycle existingMotorcycle, Motorcycle motorcycle) {
//        try {
//            existingMotorcycle.setYearLicensing(motorcycle.getYearLicensing() != null ?
//                    motorcycle.getYearLicensing() : existingMotorcycle.getYearLicensing());
//            existingMotorcycle.setFairingCondition(motorcycle.getFairingCondition() != null ?
//                    motorcycle.getFairingCondition()  :existingMotorcycle.getFairingCondition());
//            existingMotorcycle.setColor(motorcycle.getColor() != null ?
//                    motorcycle.getColor() :existingMotorcycle.getColor());
//            existingMotorcycle.setDescription(motorcycle.getDescription() != null ?
//                    motorcycle.getDescription() :existingMotorcycle.getDescription());
//            existingMotorcycle.setResultPrecautionaryExpertise(motorcycle.getResultPrecautionaryExpertise() != null ?
//                    motorcycle.getResultPrecautionaryExpertise() :existingMotorcycle.getResultPrecautionaryExpertise());
//            existingMotorcycle.setManufactureYear(motorcycle.getManufactureYear() != null ?
//                    motorcycle.getManufactureYear() :existingMotorcycle.getManufactureYear());
//            existingMotorcycle.setInitialValue(motorcycle.getInitialValue() != null ?
//                    motorcycle.getInitialValue() :existingMotorcycle.getInitialValue());
//
//            return existingMotorcycle;
//        }catch (RuntimeException e){
//            throw new UpdateObjectException();
//        }
//
//    }
}
