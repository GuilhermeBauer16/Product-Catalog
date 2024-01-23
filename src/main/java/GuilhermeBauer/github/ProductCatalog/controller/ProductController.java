package GuilhermeBauer.github.ProductCatalog.controller;
import org.springframework.data.domain.Pageable;
import GuilhermeBauer.github.ProductCatalog.domain.model.Product.ProductModel;
import GuilhermeBauer.github.ProductCatalog.services.ProductModelServices;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductModelServices productService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel productModel){
        ProductModel product = productService.create(productModel);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ProductModel>> findAllProduct(@PageableDefault(size = 10, page = 0, sort= "name") Pageable pageable) {
        Page<ProductModel> allProducts = productService.findAll(pageable);
        return ResponseEntity.ok(allProducts);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional

    public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel productModel) throws Exception {
        productService.update(productModel);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProductModel> deleteProduct(@PathVariable(value = "id")UUID uuid) throws Exception {
        productService.delete(uuid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<ProductModel> findById(@PathVariable(value = "id") UUID uuid) throws Exception {
        ProductModel productId = productService.findById(uuid);
        return ResponseEntity.ok(productId);
    }




}
