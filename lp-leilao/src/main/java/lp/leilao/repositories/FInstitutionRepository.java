package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.FinancialInstitution;

@Repository
public interface FInstitutionRepository extends CrudRepository<FinancialInstitution,Long> {
}
