package lp.leilao.dtos.converter;

import lp.leilao.dtos.*;
import lp.leilao.dtos.devices.ComputingDeviceDTO;
import lp.leilao.dtos.vehicles.VehicleDTO;
import lp.leilao.entities.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AuctionMapper {
    AuctionDTO auctionMapperToDTO(Auction auction);
    List<AuctionDTO> auctionListMapperToDTO(List<Auction> auctions);
    ComputingDeviceDTO deviceMapperToDTO(ComputingDevice computingDevice);
    VehicleDTO vehicleMapperToDTO(Vehicle vehicle);
    ClientDTO clientMapperToDTO(Client client);
    FinancialInstitutionDTO fiMapperToDTO(FinancialInstitution financialInstitution);
    BidDTO bidMapperDTO(Bid bid);
    ProductDTO productMapperDTO(Product product);

}
