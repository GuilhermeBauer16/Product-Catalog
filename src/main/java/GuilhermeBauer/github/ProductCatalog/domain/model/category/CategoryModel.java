package GuilhermeBauer.github.ProductCatalog.domain.model.category;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="Category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCategory;
    private String name;

    public CategoryModel(String name) {
        this.name = name;
    }

    public CategoryModel() {
    }

    public UUID getIdCategory() {
        return idCategory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
