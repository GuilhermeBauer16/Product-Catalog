package GuilhermeBauer.github.ProductCatalog.repositories;

import GuilhermeBauer.github.ProductCatalog.domain.model.Product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface ProductRepository extends JpaRepository<ProductModel,UUID> {
}
