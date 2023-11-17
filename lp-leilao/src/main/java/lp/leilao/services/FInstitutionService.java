package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.FinancialInstitution;
import lp.leilao.exceptions.NoInstitutionFinancialFindException;
import lp.leilao.exceptions.NoResultsFound;
import lp.leilao.repositories.FInstitutionRepository;

import java.util.List;

@Singleton
public class FInstitutionService {

    private final FInstitutionRepository financialRepository;

    //TODO: Ajustar circular dependency;
//    private final AuctionService auctionService;

    @Inject
    public FInstitutionService(FInstitutionRepository financialRepository) {
        this.financialRepository = financialRepository;
//        this.auctionService = auctionService;
    }

    public List<FinancialInstitution> getAllFI() {
        try{
            List<FinancialInstitution> financialInstitution =financialRepository.findAll();
            if (financialInstitution.isEmpty()){
                throw new NoResultsFound();
            }

            return financialInstitution;
        }catch (NoResultsFound e){
            throw new RuntimeException();
        }

    }

    public FinancialInstitution getFIById(Long fi_id) {
        try {
            return financialRepository.findById(fi_id).
                    orElseThrow(NoInstitutionFinancialFindException::new);
        }catch (NoInstitutionFinancialFindException e){
            throw new RuntimeException();
        }
    }

    public FinancialInstitution createFI(FinancialInstitution financial) {
        try {
            return financialRepository.save(financial);
        }catch (RuntimeException e){
            throw new RuntimeException();
        }
    }

    public void updateFI(Long id, FinancialInstitution updatedFI) {
        try {
            FinancialInstitution financialInstitution = getFIById(id);

            financialInstitution = updateMapper(financialInstitution, updatedFI);

            financialRepository.save(financialInstitution);

        }catch (NoResultsFound e){
            throw new RuntimeException();
        }
    }


    public void deleteFI(Long id) {
        try {
            FinancialInstitution fi = getFIById(id);
            if (!fi.getAuction().isEmpty()){
                //TODO: Ajustar circular dependency;
//                auctionService.updateAuctionForFI(fi.getAuction());
            }
            financialRepository.deleteById(id);
        }catch (RuntimeException e){
            throw new RuntimeException();
        }

    }

    private FinancialInstitution updateMapper(FinancialInstitution financialInstitution, FinancialInstitution updateFI) {

        financialInstitution.setAddress(updateFI.getAddress() != null ? updateFI.getAddress() : financialInstitution.getAddress());
        financialInstitution.setCnpj(updateFI.getCnpj() != null ? updateFI.getCnpj() : financialInstitution.getCnpj());
        financialInstitution.setName(updateFI.getName() != null ? updateFI.getName() : financialInstitution.getName());

        return financialInstitution;
    }
}
