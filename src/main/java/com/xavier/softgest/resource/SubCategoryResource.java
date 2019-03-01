package com.xavier.softgest.resource;

import com.xavier.softgest.model.Subcategory;
import com.xavier.softgest.repository.Subcategories;
import com.xavier.softgest.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryResource {

    @Autowired
    private Subcategories subcategories;

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping
    public List<Subcategory> all() {
        return subcategories.findAll();
    }

    @GetMapping("/{id}")
    public Subcategory findOne(@PathVariable Long id) {
        return subcategoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subcategory create(@Valid @RequestBody Subcategory subcategory) {
        return subcategoryService.save(subcategory);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Subcategory subcategory) {
        subcategory.setId(id);
        subcategoryService.save(subcategory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        subcategoryService.deleteById(id);
    }
}
