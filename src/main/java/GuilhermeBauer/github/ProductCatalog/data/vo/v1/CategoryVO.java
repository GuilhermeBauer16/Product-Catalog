package GuilhermeBauer.github.ProductCatalog.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CategoryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID idCategory;
    private String name;

    public CategoryVO(String name) {
        this.name = name;
    }

    public CategoryVO() {
    }

    public UUID getIdCategoryVO() {
        return idCategory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryVO that = (CategoryVO) o;
        return Objects.equals(idCategory, that.idCategory) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, name);
    }
}

