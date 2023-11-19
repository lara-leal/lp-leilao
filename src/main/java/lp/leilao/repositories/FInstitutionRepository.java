package lp.leilao.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import lp.leilao.entities.FinancialInstitution;

import java.util.Optional;

@Repository
public interface FInstitutionRepository extends CrudRepository<FinancialInstitution, Long> {
    Optional<FinancialInstitution> findByCnpj(String cnpj);
}
