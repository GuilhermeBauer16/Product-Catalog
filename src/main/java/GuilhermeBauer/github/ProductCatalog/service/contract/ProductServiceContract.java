package GuilhermeBauer.github.ProductCatalog.service.contract;

import GuilhermeBauer.github.ProductCatalog.DTO.ProductDTO;
import GuilhermeBauer.github.ProductCatalog.domain.model.ProductModel;

import java.util.UUID;

public interface ProductServiceContract {

    ProductModel createProduct(ProductDTO productDTO);

    String seeProduct(ProductModel productModel,UUID idProduct);


}
