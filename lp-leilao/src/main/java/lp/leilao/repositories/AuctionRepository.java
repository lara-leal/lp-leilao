package lp.leilao.repositories;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Auction;
@Repository
public interface AuctionRepository extends CrudRepository<Auction,Long> {
}
