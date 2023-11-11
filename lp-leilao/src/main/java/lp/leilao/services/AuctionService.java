package lp.leilao.services;

import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.java.Log;
import lp.leilao.entities.Auction;
import lp.leilao.entities.ComputingDevice;
import lp.leilao.entities.Product;
import lp.leilao.entities.Vehicle;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.enums.CategoryEnums;
import lp.leilao.exceptions.*;
import lp.leilao.repositories.AuctionRepository;
import lp.leilao.repositories.ComputingDeviceRepository;
import lp.leilao.repositories.ProductRepository;
import lp.leilao.repositories.VehicleRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Log
@Singleton
public class AuctionService {

    private final AuctionRepository auctionRepository;

    private final FInstitutionService fInstitutionService;

    private final VehicleRepository vehicleRepository;

    private final ComputingDeviceRepository deviceRepository;

    private final ProductRepository productRepository;

    @Inject
    public AuctionService(AuctionRepository auctionRepository, FInstitutionService fInstitutionService, VehicleRepository vehicleRepository, ComputingDeviceRepository deviceRepository, ProductRepository productRepository) {
        this.auctionRepository = auctionRepository;
        this.fInstitutionService = fInstitutionService;
        this.vehicleRepository = vehicleRepository;
        this.deviceRepository = deviceRepository;
        this.productRepository = productRepository;
    }

    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    public Auction getAuctionById(Long auction_id) {
        try {
            return auctionRepository.findById(auction_id).
                    orElseThrow(NoResultsFound::new);
        } catch (RuntimeException e) {
            throw new NoResultsFound();
        }
    }

    public Auction getAuctionByProdId(Long prodId) {
        try {
            return auctionRepository.findByProductId(prodId);
        } catch (RuntimeException e) {
            throw new NoResultsFound();
        }
    }

    public List<Auction> getAuctionByType(String category) {
        try {

            if(!validCategory(category)){
                throw new CategoryNotValidException();
            };

            List<Auction> auction =
                    auctionRepository.findByCategory(category);

            if (auction.isEmpty()){
                throw new NoResultsFound();
            }

            return auction;

        } catch (RuntimeException e) {
            throw new CategoryNotValidException();
        }
    }



    public void createAuction(Auction auction) {
        try{
            auction.setStatus(AuctionStatusEnum.OPEN.status);

            if (auction.getFInstitutions().isEmpty()){
                throw new NoInstitutionFinancialFindException();
            }
            auction.getFInstitutions().forEach(fi -> {
                        fInstitutionService.getFIById(fi.getFi_id());
            });

            if(!validDate(auction.getOccurrenceDate(), auction.getOccurrenceHour())){
                throw new DateAndHourAuctionOccurrenceInvalidException();
            };

            auctionRepository.save(auction);
        }catch (RuntimeException e) {
            throw new NoInstitutionFinancialFindException();
        }
    }

    private Boolean validDate(LocalDate occurrenceDate, LocalTime occurrenceTime) {
        LocalDate actuallyDate
                = LocalDate.now();

        LocalTime actuallyHour = LocalTime.now();
        if(!actuallyDate.isAfter(occurrenceDate)){
            if (occurrenceTime.isAfter(actuallyHour)){
                return true;
            }
        }
            return false;
    }

    public void updateAuction(Long auction_id, Auction updatedAuction) {
        try{
            Auction existingAuction =
                    auctionRepository.findById(auction_id).
                            orElseThrow(NoResultsFound::new);

            existingAuction = updateMapper(existingAuction, updatedAuction);

            auctionRepository.save(existingAuction);
        }catch (RuntimeException e){
            throw new NoResultsFound();
        }
    }

    private Auction updateMapper(Auction existingAuction, Auction updatedAuction) {
        existingAuction.setAddress(updatedAuction.getAddress() != null ? updatedAuction.getAddress() :existingAuction.getAddress());
        existingAuction.setOccurrenceDate(updatedAuction.getOccurrenceDate() != null ? updatedAuction.getOccurrenceDate() :existingAuction.getOccurrenceDate());
        existingAuction.setOccurrenceHour(updatedAuction.getOccurrenceHour() != null ? updatedAuction.getOccurrenceHour() :existingAuction.getOccurrenceHour());
        existingAuction.setVisitDate(updatedAuction.getVisitDate() != null ? updatedAuction.getVisitDate() :existingAuction.getVisitDate());
        existingAuction.setVisitHour(updatedAuction.getVisitHour() != null ? updatedAuction.getVisitHour() : existingAuction.getVisitHour());
        return existingAuction;
    }


    public void deleteAuction(Long auction_id) {
        try{
            List<Vehicle> vehicles = vehicleRepository.findByAuctionId(auction_id);
//            List<ComputingDevice> devices = deviceRepository.findByAuctionId(auction_id);

//            if (!vehicles.isEmpty() || !devices.isEmpty()){
//                throw new ImpossibleDeleteAuctionProductsRegisted();
//            }
            auctionRepository.deleteById(auction_id);
        }catch (RuntimeException e){
            throw new FailDeleteException() ;
        }

    }


    public boolean validCategory(String category){
        for(CategoryEnums categoryEnums : CategoryEnums.values()){
            if (categoryEnums.getStatus().equalsIgnoreCase(category)){
                return true;
            }
        }
        return false;
    }

    public void findByAuction(Auction auction) {
        auctionRepository.findById(auction.getAuctionId());
    }
}
