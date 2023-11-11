package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.entities.Product;
import lp.leilao.repositories.ProductRepository;

@Singleton
public class ProductService {

    private final ProductRepository productRepository;

    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    
}
