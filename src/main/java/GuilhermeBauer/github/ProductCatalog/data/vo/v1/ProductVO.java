package GuilhermeBauer.github.ProductCatalog.data.vo.v1;

import GuilhermeBauer.github.ProductCatalog.domain.model.category.CategoryModel;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class ProductVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Double price;
    private String description;

    private CategoryModel categoryModel;
    private String branch;
    private int quantity;
    private Boolean isAvailable;

    public ProductVO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVO productVO = (ProductVO) o;
        return quantity == productVO.quantity && Objects.equals(id, productVO.id) && Objects.equals(name, productVO.name) && Objects.equals(price, productVO.price) && Objects.equals(description, productVO.description) && Objects.equals(categoryModel, productVO.categoryModel) && Objects.equals(branch, productVO.branch) && Objects.equals(isAvailable, productVO.isAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, categoryModel, branch, quantity, isAvailable);
    }
}
