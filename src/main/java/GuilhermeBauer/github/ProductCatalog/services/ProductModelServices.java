package GuilhermeBauer.github.ProductCatalog.services;

import GuilhermeBauer.github.ProductCatalog.data.vo.v1.CategoryVO;
import GuilhermeBauer.github.ProductCatalog.data.vo.v1.ProductVO;
import GuilhermeBauer.github.ProductCatalog.domain.model.Product.ProductModel;
import GuilhermeBauer.github.ProductCatalog.domain.model.category.CategoryModel;
import GuilhermeBauer.github.ProductCatalog.exceptions.ResourceNotFoundException;
import GuilhermeBauer.github.ProductCatalog.mapper.Mapper;
import GuilhermeBauer.github.ProductCatalog.repositories.ProductRepository;
import GuilhermeBauer.github.ProductCatalog.services.contract.ServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ProductModelServices implements ServiceContract<ProductVO> {
    @Autowired
    private ProductRepository repository;
//    @Autowired
//    private CategoryModelServices categoryModelServices;

    private Logger logger = Logger.getLogger(ProductModelServices.class.getName());

    @Override
    public ProductVO create(ProductVO productVO) {

        logger.info("creating one product!");
        var entity = Mapper.parseObject(productVO, ProductModel.class);
//        checkIfCategoryExists(productVO);
        var savedEntity = repository.save(entity);
        var vo = Mapper.parseObject(savedEntity, ProductVO.class);

        return vo;
    }

    @Override
    public Page<ProductVO> findAll(Pageable pageable) {
        Page<ProductModel> productModelPage = repository.findAll(pageable);
        List<ProductVO> productVOList = Mapper.parseListObject(productModelPage.getContent(),ProductVO.class);
        return new PageImpl<>(productVOList,pageable,productModelPage.getTotalElements());
    }

    @Override
    public ProductVO update(ProductVO productVO) throws Exception {
        logger.info("Updating one product!");
        var entity = repository.findById(productVO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(productVO.getName());
        entity.setDescription(productVO.getDescription());
        entity.setPrice(productVO.getPrice());
        entity.setBranch(productVO.getBranch());
        entity.setQuantity(productVO.getQuantity());
        var vo = Mapper.parseObject(repository.save(entity), ProductVO.class);
        return vo;
    }


    @Override
    public ProductVO findById(UUID uuid) throws Exception {

        var entity = repository.findById(uuid)
                .orElseThrow(() -> new Exception("No records in this ID!"));

        return Mapper.parseObject(entity, ProductVO.class);
    }


    @Override
    public void delete(UUID uuid) throws Exception {
        logger.info("Deleting one product!");
        var entity = repository.findById(uuid)
                        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }

//    public Boolean checkIfCategoryExists(ProductVO productVO){
//
//        for (CategoryVO categoryModel: categoryModelServices.findAllCategory()){
//            if(productVO.getCategoryModel().equals(categoryModel)){
//                return true;
//            }
//        }
//
//        throw new RuntimeException("This category not exists");
//    }

}
