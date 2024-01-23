package GuilhermeBauer.github.ProductCatalog.domain.model.Product;

import GuilhermeBauer.github.ProductCatalog.domain.model.category.CategoryModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Product")
public class ProductModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Double price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;
    private String branch;
    private int quantity;
    private Boolean isAvailable;

    public ProductModel(String name, Double price, String description,
                        CategoryModel categoryModel, String branch, int quantity, Boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryModel = categoryModel;
        this.branch = branch;
        this.quantity = quantity;
        this.isAvailable = isAvailable;
    }

    public ProductModel() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
