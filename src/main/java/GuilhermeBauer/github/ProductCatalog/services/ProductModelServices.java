package GuilhermeBauer.github.ProductCatalog.services;

import GuilhermeBauer.github.ProductCatalog.domain.model.Product.ProductModel;
import GuilhermeBauer.github.ProductCatalog.repositories.ProductRepository;
import GuilhermeBauer.github.ProductCatalog.services.contract.ProductServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductModelServices implements ProductServiceContract<ProductModel> {
    @Autowired
    private ProductRepository repository;


    @Override
    public ProductModel create(ProductModel productModel) {
        return repository.save(productModel);
    }

    @Override
    public List<ProductModel> findAll() {
        return repository.findAll();
    }


    @Override
    public ProductModel update(ProductModel productModel) throws Exception {
        ProductModel entity = findById(productModel.getId());
        entity.setName(productModel.getName());
        entity.setDescription(productModel.getDescription());
        entity.setPrice(productModel.getPrice());
        entity.setCategoryModel(productModel.getCategoryModel());
        entity.setBranch(productModel.getBranch());
        entity.setQuantity(productModel.getQuantity());
        return repository.save(productModel);
    }

    @Override
    public ProductModel findById(UUID uuid) throws Exception {
        return repository.findById(uuid)
                .orElseThrow(() -> new Exception("No records in this ID!"));
    }


    @Override
    public void delete(UUID uuid) throws Exception {
        ProductModel id = findById(uuid);
        repository.delete(id);
    }

}
