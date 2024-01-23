package GuilhermeBauer.github.ProductCatalog.data.vo.v1;

import java.io.Serializable;
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
}

