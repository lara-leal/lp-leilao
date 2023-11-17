package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Auction;

import java.util.List;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Long> {
    List<Auction> findByCategory(String category);


    Auction findByProductId(Long prodId);

    List<Auction> findByStatus(String status);
}
