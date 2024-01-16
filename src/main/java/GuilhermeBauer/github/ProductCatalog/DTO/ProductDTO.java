package GuilhermeBauer.github.ProductCatalog.DTO;

import java.util.UUID;

public record ProductDTO(UUID id, String name,Double price,String description) {
}
