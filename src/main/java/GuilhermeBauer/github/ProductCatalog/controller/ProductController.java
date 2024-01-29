package GuilhermeBauer.github.ProductCatalog.controller;

import GuilhermeBauer.github.ProductCatalog.controller.contract.ControllerContract;
import GuilhermeBauer.github.ProductCatalog.data.vo.v1.ProductVO;
import GuilhermeBauer.github.ProductCatalog.services.ProductModelServices;
import GuilhermeBauer.github.ProductCatalog.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController implements ControllerContract<ProductVO> {
    @Autowired
    private ProductModelServices productService;

    @Override
    @PostMapping(produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    @Transactional
    public ResponseEntity<ProductVO> create(@RequestBody ProductVO productVO) {
        ProductVO productCreated = productService.create(productVO);
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})
    public ResponseEntity<Page<ProductVO>> findAll(@PageableDefault(size = 10, page = 0, sort = "name") Pageable pageable) {
        Page<ProductVO> allProduct = productService.findAll(pageable);
        return ResponseEntity.ok(allProduct);
    }

    @Override
    @PutMapping(consumes = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML}
    )
    @Transactional
    public ResponseEntity<ProductVO> update(@RequestBody ProductVO productVO) throws Exception {
        ProductVO ProductUpdated = productService.update(productVO);
        return ResponseEntity.ok(ProductUpdated);
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML})

    public ResponseEntity<ProductVO> findById(@PathVariable(value = "id") UUID uuid) throws Exception {
        ProductVO productId = productService.findById(uuid);
        return ResponseEntity.ok(productId);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID uuid) throws Exception {
        productService.delete(uuid);
        return ResponseEntity.noContent().build();
    }


}
