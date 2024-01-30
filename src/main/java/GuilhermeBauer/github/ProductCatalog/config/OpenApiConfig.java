package GuilhermeBauer.github.ProductCatalog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(getInfo())
                .tags(getTag());
    }

    private Info getInfo() {
        return new Info()
                .version("v0.0,1")
                .title("Product Catalog")
                .description("CRUD product catalog API");
    }

    private List<Tag> getTag() {
        return List.of(new Tag()
                .name("Product Catalog")
                .description("This API responsible to register product"));
    }
}

