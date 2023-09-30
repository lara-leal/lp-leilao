package lp.leilao.controllers;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Product;
import lp.leilao.services.ProductService;

@Controller("/products")
public class ProductController {
    @Inject
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Get("/list")
    public Iterable<Product> listProducts() {
        return productService.getAllProds();
    }

    @Get("/{id}")
    public Product getProducts(Long id) {

        return productService.getProdById(id);
    }

    @Post("/create")
    @Status(HttpStatus.CREATED)
    public Product createProduct(@Body @Valid Product product) {
        return productService.createProd(product);
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteProduct(Long id) {
        productService.deleteProd(id);
    }
}
