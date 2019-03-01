package com.xavier.softgest.resource;

import com.xavier.softgest.model.Product;
import com.xavier.softgest.repository.Products;
import com.xavier.softgest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/{id}")
public class ProductResource {

    @Autowired
    private Products products;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> all() {
        return products.findAll();
    }

    @GetMapping("/id")
    public Product findOne(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
