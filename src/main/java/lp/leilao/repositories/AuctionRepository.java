package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.data.repository.CrudRepository;
import io.micronaut.data.repository.PageableRepository;
import lp.leilao.entities.Auction;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findByCategory(String category);

    List<Auction> findAllOrderByOccurrenceDateAsc();
    Optional<Auction> findByProductId(Long prodId);

    List<Auction> findByStatus(String status);

}
