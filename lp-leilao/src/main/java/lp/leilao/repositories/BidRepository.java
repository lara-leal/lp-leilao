package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Bid;

@Repository
public interface BidRepository extends CrudRepository<Bid, Long> {
}
