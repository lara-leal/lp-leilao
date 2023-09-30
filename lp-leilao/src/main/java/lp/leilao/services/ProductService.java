package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
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

    public Product getProdById(Long id) {
        return prodRepository.findById(id).orElse(null);
    }

    public Product createProd(Product note) {
        return prodRepository.save(note);
    }

    public void deleteProd(Long id) {
        prodRepository.deleteById(id);
    }
    
}
