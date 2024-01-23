package GuilhermeBauer.github.ProductCatalog.controller;

import GuilhermeBauer.github.ProductCatalog.domain.model.Product.ProductDetail;
import GuilhermeBauer.github.ProductCatalog.domain.model.Product.ProductModel;
import GuilhermeBauer.github.ProductCatalog.services.ProductModelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductModelServices productService;

    public ProductController(ProductModelServices productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ProductModel> createProduct(ProductModel productModel){
        ProductModel product = productService.create(productModel);
        return ResponseEntity.ok().body(productModel);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductModel>> findAllProduct(){
         productService.findAll();
         return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ProductModel> updateProduct(ProductModel productModel) throws Exception {
        productService.update(productModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = " uuid")UUID uuid) throws Exception {
        productService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ProductModel> findById(@PathVariable(value = "uuid") UUID uuid) throws Exception {
        productService.findById(uuid);
        return ResponseEntity.ok().build();
    }




}
