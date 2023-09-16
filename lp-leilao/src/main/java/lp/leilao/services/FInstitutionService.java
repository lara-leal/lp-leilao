package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.FinancialInstitution;
import lp.leilao.repositories.FInstitutionRepository;

@Singleton
public class FInstitutionService {
    @Inject
    private final FInstitutionRepository financialRepository;

    public FInstitutionService(FInstitutionRepository financialRepository) {
        this.financialRepository = financialRepository;
    }

    public Iterable<FinancialInstitution> getAllFI() {
        return financialRepository.findAll();
    }

    public FinancialInstitution getFIById(Long id) {
        return financialRepository.findById(id).orElse(null);
    }

    public FinancialInstitution createFI(FinancialInstitution financial) {
        return financialRepository.save(financial);
    }

    public void deleteFI(Long id) {
        financialRepository.deleteById(id);
    }
}
