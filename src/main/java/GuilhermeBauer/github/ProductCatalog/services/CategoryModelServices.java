package GuilhermeBauer.github.ProductCatalog.services;

import GuilhermeBauer.github.ProductCatalog.data.vo.v1.CategoryVO;
import GuilhermeBauer.github.ProductCatalog.domain.model.category.CategoryModel;
import GuilhermeBauer.github.ProductCatalog.exceptions.ResourceNotFoundException;
import GuilhermeBauer.github.ProductCatalog.mapper.Mapper;
import GuilhermeBauer.github.ProductCatalog.repositories.CategoryRepository;
import GuilhermeBauer.github.ProductCatalog.services.contract.ServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;


@Service
public class CategoryModelServices implements ServiceContract<CategoryVO> {

    private final Logger logger = Logger.getLogger(CategoryModelServices.class.getName());
    @Autowired
    private CategoryRepository repository;

    @Override
    public CategoryVO create(CategoryVO categoryVO) {

        logger.info("Creating one category");
        var entity = Mapper.parseObject(categoryVO, CategoryModel.class);
        entity.getName().toUpperCase();
        entity.setIdCategory(categoryVO.getIdCategoryVO());
        var vo = Mapper.parseObject(repository.save(entity),CategoryVO.class);
        return vo;
    }

    @Override
    public Page<CategoryVO> findAll(Pageable pageable) {

        Page<CategoryModel> categoryModelPage = repository.findAll(pageable);

        List<CategoryVO> categoryVOPage = Mapper.parseListObject(categoryModelPage.getContent(), CategoryVO.class);
        return new PageImpl<>(categoryVOPage,pageable,categoryModelPage.getTotalElements());
    }

    @Override
    public CategoryVO update(CategoryVO categoryVO) throws Exception {
        logger.info("Updating one category");
        var entity = repository.findById(categoryVO.getIdCategoryVO())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(categoryVO.getName());
        var vo = Mapper.parseObject(repository.save(entity), CategoryVO.class);
        return vo;
    }

    @Override
    public CategoryVO findById(UUID uuid) throws Exception {

        var entity = repository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return Mapper.parseObject(entity, CategoryVO.class);
    }

    @Override
    public void delete(UUID uuid) throws Exception {
        logger.info("Deleting one category");
        var entity = repository.findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);

    }
}
