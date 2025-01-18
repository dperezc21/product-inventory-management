import com.prueba.productInventoryManagement.application.CategoryUseCase;
import com.prueba.productInventoryManagement.application.ProductUseCase;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ProductUseCase productBean() { return new ProductUseCase(); }

    @Bean
    public CategoryUseCase categoryBean() { return new CategoryUseCase(); }
}
