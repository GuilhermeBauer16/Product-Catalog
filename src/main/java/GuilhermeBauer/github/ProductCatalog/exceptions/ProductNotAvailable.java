package GuilhermeBauer.github.ProductCatalog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotAvailable extends RuntimeException {

    public ProductNotAvailable(String message) {
        super(message);
    }
}
