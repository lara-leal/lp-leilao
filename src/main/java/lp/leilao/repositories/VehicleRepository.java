package lp.leilao.repositories;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    @Query(value = "select * from vehicle v where v.auction_id = :auctionId",
            nativeQuery = true)
    List<Vehicle> findByAuctionId(Long auctionId);

    List<Vehicle> findByCategory(String validCategory);
}
