package lp.leilao.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lp.leilao.entities.Product;
import lp.leilao.services.ProductService;

@Controller("/products")
@Tag(name = "Products")
public class ProductController {
//    @Inject
//    private final ProductService productService;
//
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//    @Get("/list")
//    public Iterable<Product> listProducts() {
//        return productService.getAllProds();
//    }
//
//    @Get("/{prod_id}")
//    public Product getProducts(Long prod_id) {
//
//        return productService.getProdById(prod_id);
//    }
//
//    @Post("/create")
//    @Status(HttpStatus.CREATED)
//    public Product createProduct(@Body @Valid Product product) {
//        return productService.createProd(product);
//    }
//
//    @Put("/{prod_id}")
//    public HttpResponse<Product> updateProd(@PathVariable Long prod_id, @Body Product updatedProd) {
//        Product updated = productService.updateProd(prod_id, updatedProd);
//        if (updated != null) {
//            return HttpResponse.ok(updated);
//        } else {
//            return HttpResponse.notFound();
//        }
//    }
//
//    @Delete("/{prod_id}")
//    @Status(HttpStatus.NO_CONTENT)
//    public void deleteProduct(Long prod_id) {
//        productService.deleteProd(prod_id);
//    }
}
