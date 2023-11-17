package lp.leilao.dtos.converter;

import lp.leilao.dtos.AuctionDTO;
import lp.leilao.entities.Auction;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


public class AuctionToDTO {
    ModelMapper mapper = new ModelMapper();
    private List<AuctionDTO> mapperDTO(List<Auction> auctions) {

        List<AuctionDTO> auctionDTO = new ArrayList<>();
        auctions.forEach(auction -> {

        });
        return auctionDTO;
    }
}
