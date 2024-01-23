package GuilhermeBauer.github.ProductCatalog.services.contract;


import java.util.List;
import java.util.UUID;


public interface ProductServiceContract<T> {

    T create(T t);

    List<T> findAll();

    T update(T t) throws Exception;

    T findById(UUID uuid) throws Exception;

    void delete(UUID uuid) throws Exception;

}
