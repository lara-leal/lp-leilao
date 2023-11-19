package lp.leilao.dtos.converter;

import io.micronaut.data.model.Sort;
import lp.leilao.dtos.*;
import lp.leilao.dtos.devices.ComputingDeviceDTO;
import lp.leilao.dtos.vehicles.VehicleDTO;
import lp.leilao.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AuctionMapper {
    AuctionDTO auctionMapperToDTO(Auction auction);

    Auction dtoToAuction(AuctionDTO auctionDTO);

    @Mapping(source = "product.devices", target = "product.devices" )
    List<AuctionDTO> auctionListMapperToDTO(List<Auction> auctions);
    ComputingDeviceDTO deviceMapperToDTO(ComputingDevice computingDevice);
    VehicleDTO vehicleMapperToDTO(Vehicle vehicle);
    ClientDTO clientMapperToDTO(Client client);
    FinancialInstitutionDTO fiMapperToDTO(FinancialInstitution financialInstitution);
    BidDTO bidToDTO(Bid bid);

    Bid dtoToEntity(BidDTO bidDTO);

    ProductDTO productMapperDTO(Product product);
    Vehicle vehicleDTOMapperEntity(VehicleDTO vehicleDTO);

    Auction DTOToEntity(AuctionInputDTO auctionInputDTO);

    FinancialInstitution FiDTOMapperEntity(FinancialInstitutionDTO financial);

    List<BidDTO> bidToDTOList(List<Bid> bid);

    List<ComputingDeviceDTO> deviceMapperToDTOList(List<ComputingDevice> devices);

    @Mapping(source = "productId", target = "product.id")
    ComputingDevice deviceDTOToEntity(ComputingDeviceDTO device);

    List<VehicleDTO> vehicleMapperToDTOList(List<Vehicle> vehicles);

    @Mapping(source = "product.id", target = "productId")
    VehicleUpdateDTO vehicleToDTOUpdate(Vehicle vehicle);

    @Mapping(source = "product.id", target = "productId")
    ComputingDeviceUpdateDTO deviceEntityToUpdateDTO(ComputingDevice device);
    
    @Mapping(source = "productId", target = "product.id")
    Vehicle vehicleUpdateToEntity(VehicleUpdateDTO vehicle);

    @Mapping(source = "productId", target = "product.id")
    ComputingDevice deviceUpdateToEntity(ComputingDeviceUpdateDTO deviceDTO);

    @Mapping(source = "product", target = "product", ignore = true)
    List<AuctionInputDTO> EntityToDTO(List<Auction> all);

    ProductDTOInput proUpdateDTO(Product product);

    Client ClientDtoToEntity(ClientDTO client);

    BidUpdateWinnerDTO bidWinnerToDTO(Bid bid);
}
