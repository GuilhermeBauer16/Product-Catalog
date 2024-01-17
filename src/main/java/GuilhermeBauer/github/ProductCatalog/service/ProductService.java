package GuilhermeBauer.github.ProductCatalog.service;

import GuilhermeBauer.github.ProductCatalog.DTO.ProductDTO;
import GuilhermeBauer.github.ProductCatalog.domain.model.Product.ProductModel;
import GuilhermeBauer.github.ProductCatalog.service.contract.ProductServiceContract;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ProductService implements ProductServiceContract {
    @Override
    public ProductModel createProduct(ProductDTO productDTO) {
        return ProductModel.builder()
                .id(productDTO.id())
                .name(productDTO.name())
                .price(productDTO.price())
                .description(productDTO.description())
                .build();
    }

    @Override
    public String seeProduct(ProductModel productModel, UUID idProduct) {
        if(productModel.getId().equals(idProduct))
            return productModel.toString();

        throw new RuntimeException();
    }

}
