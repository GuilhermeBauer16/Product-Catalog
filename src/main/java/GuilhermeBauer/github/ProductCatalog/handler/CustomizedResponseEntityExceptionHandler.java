package GuilhermeBauer.github.ProductCatalog.handler;

import GuilhermeBauer.github.ProductCatalog.exceptions.CategoryNotFound;
import GuilhermeBauer.github.ProductCatalog.exceptions.ExceptionResponse;
import GuilhermeBauer.github.ProductCatalog.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)

    public final ResponseEntity<ExceptionResponse> handlerNotFoundException(
            Exception ex,
            WebRequest webRequest){

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                webRequest.getDescription(false)

        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);



    }

    @ExceptionHandler(CategoryNotFound.class)

    public ResponseEntity<ExceptionResponse> handlerClassNotFoundException(
            Exception ex,
            WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), ex.getMessage(), webRequest.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
    }
}
