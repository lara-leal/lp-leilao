package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.FinancialInstitution;
import lp.leilao.entities.Product;
import lp.leilao.repositories.ProductRepository;

@Singleton
public class ProductService {
    @Inject
    private final ProductRepository prodRepository;

    public ProductService(ProductRepository prodRepository) {
        this.prodRepository = prodRepository;
    }

    public Iterable<Product> getAllProds() {
        return prodRepository.findAll();
    }

    public Product getProdById(Long prod_id) {
        return prodRepository.findById(prod_id).orElse(null);
    }

    public Product createProd(Product product) {
        return prodRepository.save(product);
    }

    public Product updateProd(Long prod_id, Product updatedProd) {
        Product existingProd = prodRepository.findById(prod_id).orElse(null);
        if (existingProd != null) {
            existingProd.setName(updatedProd.getName());
            existingProd.setDescription(updatedProd.getDescription());
            existingProd.setInitialValue(updatedProd.getInitialValue());

            return prodRepository.update(existingProd);
        }
        return null;
    }
    
    public void deleteProd(Long prod_id) {
        prodRepository.deleteById(prod_id);
    }
    
}
