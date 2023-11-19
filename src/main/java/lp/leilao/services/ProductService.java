package lp.leilao.services;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lp.leilao.repositories.ProductRepository;
import lp.leilao.services.devices.ComputingDeviceService;
import lp.leilao.services.vehicles.VehicleService;

@Singleton
public class ProductService {

    private final ProductRepository productRepository;


    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    
}
