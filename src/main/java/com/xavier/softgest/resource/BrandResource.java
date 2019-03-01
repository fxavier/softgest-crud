package com.xavier.softgest.resource;

import com.xavier.softgest.model.Brand;
import com.xavier.softgest.repository.Brands;
import com.xavier.softgest.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/brands")
public class BrandResource {

    @Autowired
    private Brands brands;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> all() {
        return brands.findAll();
    }

    @GetMapping("/{id}")
    public Brand findOne(@PathVariable Long id) {
        return brandService.findOne(id);
    }

    @PostMapping
    public Brand create(@Valid @RequestBody Brand brand) {
        return brandService.save(brand);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Brand brand) {
        brand.setId(id);
        brandService.save(brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        brandService.deleteById(id);
    }

}
