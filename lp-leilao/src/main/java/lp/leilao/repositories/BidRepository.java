package lp.leilao.repositories;

import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Bid;

public interface BidRepository extends CrudRepository<Bid, Long> {
}
