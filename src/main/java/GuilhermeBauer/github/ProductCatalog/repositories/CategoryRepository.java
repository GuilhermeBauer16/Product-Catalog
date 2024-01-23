package GuilhermeBauer.github.ProductCatalog.repositories;

import GuilhermeBauer.github.ProductCatalog.domain.model.category.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {
}
