package GuilhermeBauer.github.ProductCatalog.domain.model;

import GuilhermeBauer.github.ProductCatalog.DTO.ProductDTO;

import java.util.UUID;

public record ProductDetail(UUID id, String name, Double price, String description) {

    public ProductDetail(ProductModel products){
        this(products.getId(), products.getName(), products.getPrice(), products.getDescription());

    }
}
