package GuilhermeBauer.github.ProductCatalog.controller;

import GuilhermeBauer.github.ProductCatalog.controller.contract.ControllerContract;
import GuilhermeBauer.github.ProductCatalog.data.vo.v1.CategoryVO;
import GuilhermeBauer.github.ProductCatalog.services.CategoryModelServices;
import GuilhermeBauer.github.ProductCatalog.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController implements ControllerContract<CategoryVO> {
    @Autowired
    private CategoryModelServices categoryModelServices;


    @Override
    @PostMapping(
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML}
    )
    @Transactional
    public ResponseEntity<CategoryVO> create(@RequestBody CategoryVO categoryVO) {
        var createdEntity = categoryModelServices.create(categoryVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML})
    public ResponseEntity<Page<CategoryVO>> findAll(Pageable pageable) {

        Page<CategoryVO> categoryVOPage = categoryModelServices.findAll(pageable);
        return ResponseEntity.ok(categoryVOPage);
    }

    @Override
    @PutMapping(consumes = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML},
    produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public ResponseEntity<CategoryVO> update(@RequestBody CategoryVO categoryVO) throws Exception {
        categoryModelServices.update(categoryVO);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping(value = "/{id}",
    produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public ResponseEntity<CategoryVO> findById(@PathVariable(value= "id")UUID uuid) throws Exception {
        CategoryVO categoryId = categoryModelServices.findById(uuid);
        return ResponseEntity.ok(categoryId);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoryVO> delete(@PathVariable(value = "id") UUID uuid) throws Exception{
        categoryModelServices.delete(uuid);
        return ResponseEntity.noContent().build();
    }
}
