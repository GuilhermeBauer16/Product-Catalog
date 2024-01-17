package GuilhermeBauer.github.ProductCatalog.domain.model.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="Category")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCategory;
    private String name;

}
