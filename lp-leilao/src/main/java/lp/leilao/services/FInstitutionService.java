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

    public FinancialInstitution getFIById(Long fi_id) {
        return financialRepository.findById(fi_id).orElse(null);
    }

    public FinancialInstitution createFI(FinancialInstitution financial) {
        return financialRepository.save(financial);
    }

    public FinancialInstitution updateFI(Long auction_id, FinancialInstitution updatedFI) {
        FinancialInstitution existingFI = financialRepository.findById(auction_id).orElse(null);
        if (existingFI != null) {
            existingFI.setName(updatedFI.getName());
            existingFI.setCnpj(updatedFI.getCnpj());
            existingFI.setAddress(updatedFI.getAddress());

            return financialRepository.update(existingFI);
        }
        return null;
    }


    public void deleteFI(Long fi_id) {
        financialRepository.deleteById(fi_id);
    }
}
