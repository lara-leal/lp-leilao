package lp.leilao.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import lp.leilao.dtos.AuctionDTO;
import lp.leilao.dtos.AuctionInputDTO;
import lp.leilao.dtos.converter.AuctionMapper;
import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.dtos.devices.ComputingDeviceDTO;
import lp.leilao.dtos.vehicles.VehicleDTO;
import lp.leilao.entities.*;
import lp.leilao.enums.AuctionStatusEnum;
import lp.leilao.enums.CategoryEnums;
import lp.leilao.exceptions.*;
import lp.leilao.repositories.AuctionRepository;
import lp.leilao.repositories.ComputingDeviceRepository;
import lp.leilao.repositories.VehicleRepository;

import java.io.*;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log
@Singleton
public class AuctionService {

    private final AuctionRepository auctionRepository;

    private final FInstitutionService fInstitutionService;

    private final ComputingDeviceRepository deviceRepository;

    private final VehicleRepository vehicleRepository;

    private AuctionMapper auctionMapper = new AuctionMapperImpl();

    @Inject
    public AuctionService(AuctionRepository auctionRepository, FInstitutionService fInstitutionService,
            ComputingDeviceRepository deviceRepository, VehicleRepository vehicleRepository) {

        this.auctionRepository = auctionRepository;
        this.fInstitutionService = fInstitutionService;
        this.deviceRepository = deviceRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public List<AuctionDTO> getAllAuctions(@Nullable Double min, @Nullable Double max, @Nullable String keyWord,
            @Nullable String category) {

        List<AuctionDTO> auctions = auctionMapper.auctionListMapperToDTO(auctionRepository
                .findAllOrderByOccurrenceDateAsc());

        auctions.forEach(auction -> {
            auction.getProduct().setDevices(doFilterDeviceMaxAndMin(auction, min, max, keyWord));
            auction.getProduct().setVehicles(doFilterVehicleMaxAndMin(auction, min, max));
        });

        if (!category.equalsIgnoreCase("BOTH") && validCategory(category)) {
            auctions = auctions.stream().filter(auctionDTO -> auctionDTO.getCategory()
                    .equalsIgnoreCase(category)).collect(Collectors.toList());
        }

        return (auctions);
    }

    public Auction getAuctionById(Long auction_id) {
        try {
            return auctionRepository.findById(auction_id).orElseThrow(NoResultsFound::new);
        } catch (RuntimeException e) {
            throw new NoResultsFound();
        }
    }

    public List<Auction> getAuctionByStatus(String status) {
        return auctionRepository.findByStatus(status);
    }

    public Auction getAuctionByProdId(Long prodId) {
        Optional<Auction> auction = auctionRepository.findByProductId(prodId);
        if (auction.isEmpty()) {
            throw new NoResultsFound();
        }
        return auction.get();
    }

    public List<AuctionDTO> getAuctionByType(String category) {
        if (!validCategory(category)) {
            throw new InvalidCategoryException();
        }
        List<Auction> auction = auctionRepository.findByCategory(category);
        if (auction.isEmpty()) {
            throw new NoResultsFound();
        }
        return auctionMapper.auctionListMapperToDTO(auction);
    }

    public void createAuction(@Valid AuctionInputDTO auction) {
        auction.setStatus(AuctionStatusEnum.OPEN.status);

        if (auction.getFInstitutions().isEmpty()) {
            throw new NoInstitutionFinancialFindException();
        }
        auction.getFInstitutions().forEach(fi -> {
            fInstitutionService.getFIById(fi.getFiid());
        });

        if (!validDate(auction.getOccurrenceDate(), auction.getFinishDate())) {
            throw new DateAndHourAuctionOccurrenceInvalidException();
        }
        ;

        auctionRepository.save(auctionMapper.DTOToEntity(auction));
    }

    public Boolean validDate(LocalDateTime occurrenceDate, LocalDateTime finishDate) {
        LocalDateTime actuallyDate = LocalDateTime.now();
        if (actuallyDate.isBefore(occurrenceDate) && finishDate.isAfter(actuallyDate)) {
            return true;
        }
        return false;
    }

    public void updateAuction(Long id, AuctionInputDTO updatedAuction) {
        Auction existingAuction = auctionRepository.findById(id).orElseThrow(NoResultsFound::new);

        existingAuction = updateMapper(existingAuction,
                auctionMapper.DTOToEntity(updatedAuction));

        auctionRepository.update(existingAuction);
    }

    private Auction updateMapper(Auction existingAuction, Auction updatedAuction) {
        existingAuction.setAddress(
                updatedAuction.getAddress() != null ? updatedAuction.getAddress() : existingAuction.getAddress());
        existingAuction
                .setOccurrenceDate(updatedAuction.getOccurrenceDate() != null ? updatedAuction.getOccurrenceDate()
                        : existingAuction.getOccurrenceDate());
        existingAuction.setVisitDate(
                updatedAuction.getVisitDate() != null ? updatedAuction.getVisitDate() : existingAuction.getVisitDate());
        return existingAuction;
    }

    public void deleteAuction(Long id) {
        @NonNull
        Optional<Auction> auction = auctionRepository.findById(id);
        auctionRepository.deleteById(id);
        vehicleRepository.deleteAll(auction.get().getProduct().getVehicles());
        deviceRepository.deleteAll(auction.get().getProduct().getDevices());
    }

    public boolean validCategory(String category) {
        for (CategoryEnums categoryEnums : CategoryEnums.values()) {
            if (categoryEnums.getStatus().equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }

    public void updateAuctionForFI(List<Auction> auctions) {
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("auction" + id + ".det"));

        writer.write(json);

        writer.close();
    }

    public void updateAuctionStatus(List<Auction> statusUpdate) {
        auctionRepository.updateAll(statusUpdate);
    }

    private List<VehicleDTO> doFilterVehicleMaxAndMin(AuctionDTO auction, Double min, Double max) {
        List<VehicleDTO> vehicles = new ArrayList<>();
        if (!auction.getProduct().getVehicles().isEmpty()) {
            vehicles = auction.getProduct()
                    .getVehicles().stream()
                    .filter(vehicle -> vehicle.getInitialValue() >= min && vehicle.getInitialValue() <= max)
                    .collect(Collectors.toList());

        }
        ;

        if (auction.getStatus().equalsIgnoreCase(AuctionStatusEnum.FINISHED.status)) {
            vehicles.forEach(vehicle -> vehicle.getBids().forEach(bid -> {
                if (!bid.getWinner().equals(Boolean.TRUE)) {
                    bid.setClient(null);
                }
            }));
        }
        return vehicles;
    }

    private List<ComputingDeviceDTO> doFilterDeviceMaxAndMin(AuctionDTO auction, Double min, Double max,
            String keyWord) {
        List<ComputingDeviceDTO> computingDevice = new ArrayList<>();
        if (!auction.getProduct().getDevices().isEmpty()) {
            computingDevice = auction.getProduct()
                    .getDevices().stream()
                    .filter(device -> device.getInitialValue() >= min && device.getInitialValue() <= max
                            && device.getName().contains(keyWord))
                    .collect(Collectors.toList());
        }
        ;

        if (!auction.getStatus().equalsIgnoreCase(AuctionStatusEnum.FINISHED.status)) {
            computingDevice.forEach(device -> device.getBids().forEach(bid -> {
                if (!bid.getWinner().equals(Boolean.TRUE)) {
                    bid.setClient(null);
                }
            }));
        }

        return computingDevice;
    }

}
