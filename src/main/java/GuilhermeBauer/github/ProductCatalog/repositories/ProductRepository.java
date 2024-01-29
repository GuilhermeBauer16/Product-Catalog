package GuilhermeBauer.github.ProductCatalog.repositories;

import GuilhermeBauer.github.ProductCatalog.data.vo.v1.CategoryVO;
import GuilhermeBauer.github.ProductCatalog.domain.model.Product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;
public interface ProductRepository extends JpaRepository<ProductModel,UUID> {

}
