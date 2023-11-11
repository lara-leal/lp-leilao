package lp.leilao.repositories;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Auction;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Long> {
    List<Auction> findByCategory(String category);


    Auction findByProductId(Long prodId);
}
