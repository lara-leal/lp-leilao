package lp.leilao.services.vehicles;

import jakarta.inject.Singleton;


@Singleton
public class CarService {

//    private final CarRepository carRepository;
//
//    private final AuctionService auctionService;
//
//    @Inject
//    public CarService(CarRepository carRepository, AuctionService auctionService) {
//        this.carRepository = carRepository;
//        this.auctionService = auctionService;
//    }
//
//    public List<CarDTO> getAllCars() {
//        try {
//            List<CarDTO> cars = carRepository.findAll();
//            if (cars.isEmpty()){
//                throw new NoResultsFound();
//            }
//
//            return cars;
//        }catch (RuntimeException e){
//            throw new NoResultsFound();
//        }
//    }
//
//    public CarDTO getCarById(Long id) {
//        try {
//            return carRepository.findById(id).orElseThrow(NoResultsFound::new);
//        } catch (NoResultsFound e) {
//            throw new NoResultsFound();
//        }
//
//    }
//
//    public void createCar(CarDTO car) {
//        try{
//            Auction auction = auctionService.getAuctionById(null);
//            if (auction.equals(null)){
//                throw new NoAuctionFoundException();
//            }
//            carRepository.save(car);
//        }catch (RuntimeException e) {
//            throw new NoAuctionFoundException();
//        }
//    }
//
//    public void updateCar(Long id, CarDTO car) {
//        try {
//            CarDTO existingCar = getCarById(id);
//            CarDTO updateCar = updateMapper(existingCar, car);
//
//            carRepository.update(updateCar);
//        } catch (RuntimeException e) {
//            throw new NoResultsFound();
//        }
//    }
//
//    public void deleteCar(Long id) {
//        try{
//            carRepository.deleteById(id);
//        }catch (FailDeleteException e){
//            throw new RuntimeException() ;
//        }
//    }
//
//    private CarDTO updateMapper(CarDTO existingCar, CarDTO car) {
//        try {
//            existingCar.setBodywork(car.getBodywork() != null ? car.getBodywork() : existingCar.getBodywork());
//            existingCar.setSunroof(car.getSunroof() != null ? car.getSunroof()  : existingCar.getSunroof());
//            existingCar.setBrand(car.getBrand() != null ? car.getBrand() : existingCar.getBrand());
//            existingCar.setColor(car.getColor() != null ? car.getColor() : existingCar.getColor());
//            existingCar.setYearLicensing(car.getYearLicensing() != null ? car.getYearLicensing() : existingCar.getYearLicensing());
//            existingCar.setDescription(car.getDescription() != null ? car.getDescription() : existingCar.getDescription());
//            existingCar.setInitialValue(car.getInitialValue() != null ? car.getInitialValue() :existingCar.getInitialValue());
//            existingCar.setModel(car.getModel() != null ? car.getModel() : existingCar.getModel());
//            return existingCar;
//        }catch (RuntimeException e){
//            throw new UpdateObjectException();
//        }
//
//    }

}
