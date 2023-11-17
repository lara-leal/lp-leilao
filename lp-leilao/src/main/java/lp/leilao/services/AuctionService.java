package lp.leilao.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.java.Log;
import lp.leilao.dtos.AuctionDTO;
import lp.leilao.dtos.converter.AuctionMapper;
//import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.entities.*;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.enums.CategoryEnums;
import lp.leilao.exceptions.*;
import lp.leilao.repositories.AuctionRepository;
import lp.leilao.repositories.ComputingDeviceRepository;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Log
@Singleton
public class AuctionService {

    private final AuctionRepository auctionRepository;

    private final FInstitutionService fInstitutionService;

    private final ComputingDeviceRepository deviceRepository;

    private final ProductService productService;

    private AuctionMapper auctionMapper = new AuctionMapperImpl();

    @Inject
    public AuctionService(AuctionRepository auctionRepository, FInstitutionService fInstitutionService, ComputingDeviceRepository deviceRepository, ProductService productService) {
        this.auctionRepository = auctionRepository;
        this.fInstitutionService = fInstitutionService;
        this.deviceRepository = deviceRepository;
        this.productService = productService;
    }

    public List<AuctionDTO> getAllAuctions() {
        return auctionMapper.auctionListMapperToDTO(auctionRepository.findAll());
    }

    public Auction getAuctionById(Long auction_id) {
        try {
            return auctionRepository.findById(auction_id).
                    orElseThrow(NoResultsFound::new);
        } catch (RuntimeException e) {
            throw new NoResultsFound();
        }
    }


    public List<Auction> getAuctionByStatus(String status){
        return auctionRepository.findByStatus(status);
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
                        fInstitutionService.getFIById(fi.getFiid());
            });

            if(!validDate(auction.getOccurrenceDate(), auction.getOccurrenceHour())){
                throw new DateAndHourAuctionOccurrenceInvalidException();
            };

            auctionRepository.save(auction);
        }catch (RuntimeException e) {
            throw new NoInstitutionFinancialFindException();
        }
    }

    public Boolean validDate(LocalDate occurrenceDate, LocalTime occurrenceTime) {
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

    public void updateAuction(Long id, Auction updatedAuction) {
        try{
            Auction existingAuction =
                    auctionRepository.findById(id).
                            orElseThrow(NoResultsFound::new);

            existingAuction = updateMapper(existingAuction, updatedAuction);

            auctionRepository.update(existingAuction);
        }catch (RuntimeException e){
            throw new NoResultsFound();
        }
    }

    private Auction updateMapper(Auction existingAuction, Auction updatedAuction) {
        existingAuction.setAddress(updatedAuction.getAddress() != null ? updatedAuction.getAddress() :existingAuction.getAddress());
        existingAuction.setOccurrenceDate(updatedAuction.getOccurrenceDate() != null ? updatedAuction.getOccurrenceDate() : existingAuction.getOccurrenceDate());
        existingAuction.setOccurrenceHour(updatedAuction.getOccurrenceHour() != null ? updatedAuction.getOccurrenceHour() : existingAuction.getOccurrenceHour());
        existingAuction.setVisitDate(updatedAuction.getVisitDate() != null ? updatedAuction.getVisitDate() :existingAuction.getVisitDate());
        existingAuction.setVisitHour(updatedAuction.getVisitHour() != null ? updatedAuction.getVisitHour() : existingAuction.getVisitHour());
        return existingAuction;
    }


    public void deleteAuction(Long id) {
        try{
            Auction auction = getAuctionById(id);
            productService.deleteProduct(auction.getProduct().id);
            deviceRepository.deleteAll(auction.getProduct().getDevices());

            auctionRepository.deleteById(id);

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

    public void updateAuctionForFI(List<Auction> auctions){
        List<Auction> auctionsWithNoFI = new ArrayList<>();
        auctions.forEach(auction -> {
            auction.setFInstitutions(null);
            auction.setStatus(AuctionStatusEnum.INACTIVE.status);
            auctionsWithNoFI.add(auction);
        });

        auctionRepository.saveAll(auctionsWithNoFI);
    }

    public void exportDatFile(Long id) throws IOException {
        Auction auction = getAuctionById(id);

        AuctionDTO auctionDTO = auctionMapper.auctionMapperToDTO(auction);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

        String json = objectWriter.writeValueAsString(auctionDTO);
        BufferedWriter writer =
                new BufferedWriter(new FileWriter("src/main/java/lp/leilao/dat/auction" + id +".dat"));

        writer.write(json);

        writer.close();
    }


    public void updateAuctionStatus(List<Auction> statusUpdate) {
        auctionRepository.saveAll(statusUpdate);
    }
}
