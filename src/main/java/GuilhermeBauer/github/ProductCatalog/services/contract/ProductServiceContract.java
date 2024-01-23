package GuilhermeBauer.github.ProductCatalog.services.contract;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;


public interface ProductServiceContract<T> {

    T create(T t);

    Page<T> findAll(Pageable pageable);

    T update(T t) throws Exception;

    T findById(UUID uuid) throws Exception;

    void delete(UUID uuid) throws Exception;

}
