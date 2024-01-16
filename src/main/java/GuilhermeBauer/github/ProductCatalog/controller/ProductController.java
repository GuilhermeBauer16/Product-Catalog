package GuilhermeBauer.github.ProductCatalog.controller;

import GuilhermeBauer.github.ProductCatalog.DTO.ProductDTO;
import GuilhermeBauer.github.ProductCatalog.domain.model.ProductDetail;
import GuilhermeBauer.github.ProductCatalog.domain.model.ProductModel;
import GuilhermeBauer.github.ProductCatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDetail> insertProduct(ProductDTO productDTO){
        ProductModel product = productService.createProduct(productDTO);
        return ResponseEntity.ok().body(new ProductDetail(product));
    }

    @GetMapping
    public ResponseEntity<ProductModel> seeProduct(UUID id){
        ResponseEntity<ProductModel> productModelResponseEntity = seeProduct(id);
        return ResponseEntity.ok(productModelResponseEntity).getBody();
    }


}
