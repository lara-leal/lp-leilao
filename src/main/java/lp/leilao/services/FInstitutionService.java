package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.validation.Valid;
import lp.leilao.dtos.FinancialInstitutionDTO;
import lp.leilao.dtos.converter.AuctionMapper;
import lp.leilao.dtos.converter.AuctionMapperImpl;
import lp.leilao.entities.FinancialInstitution;
import lp.leilao.exceptions.NoInstitutionFinancialFindException;
import lp.leilao.exceptions.NoResultsFound;
import lp.leilao.repositories.FInstitutionRepository;

import java.util.List;
import java.util.Optional;

@Singleton
public class FInstitutionService {

    private final FInstitutionRepository financialRepository;

    private AuctionMapper mapper = new AuctionMapperImpl();


    @Inject
    public FInstitutionService(FInstitutionRepository financialRepository) {
        this.financialRepository = financialRepository;
    }

    public List<FinancialInstitution> getAllFI() {
            List<FinancialInstitution> financialInstitution =financialRepository.findAll();
            if (financialInstitution.isEmpty()){
                throw new NoResultsFound();
            }

            return financialInstitution;
    }

    public FinancialInstitution getFIById(Long fi_id) {
        return financialRepository.findById(fi_id).
                orElseThrow(NoInstitutionFinancialFindException::new);
    }


    public Optional<FinancialInstitution> getFiByCnpj(String cnpj) {
        Optional<FinancialInstitution> fi = financialRepository.findByCnpj(cnpj);
        if (fi.isEmpty()){
            throw new NoInstitutionFinancialFindException();
        }
        return fi;
    }

    public FinancialInstitution createFI(@Valid FinancialInstitutionDTO financial){
        return financialRepository.save(mapper.FiDTOMapperEntity(financial));
    }

    public void updateFI(Long id, FinancialInstitution updatedFI) {
            FinancialInstitution financialInstitution = getFIById(id);

            financialInstitution = updateMapper(financialInstitution, updatedFI);

            financialRepository.save(financialInstitution);
    }


    public void deleteFI(Long id) {
            financialRepository.deleteById(id);

    }

    private FinancialInstitution updateMapper(FinancialInstitution financialInstitution, FinancialInstitution updateFI) {

        financialInstitution.setAddress(updateFI.getAddress() != null ? updateFI.getAddress() : financialInstitution.getAddress());
        financialInstitution.setCnpj(updateFI.getCnpj() != null ? updateFI.getCnpj() : financialInstitution.getCnpj());
        financialInstitution.setName(updateFI.getName() != null ? updateFI.getName() : financialInstitution.getName());

        return financialInstitution;
    }
}
