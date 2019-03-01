package com.xavier.softgest.resource;

import com.xavier.softgest.model.Category;
import com.xavier.softgest.repository.Categories;
import com.xavier.softgest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private Categories categories;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> all() {
        return categories.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findOne(@PathVariable Long id) {
        Optional<Category> foundCategory = categories.findById(id);
        return foundCategory.isPresent() ? ResponseEntity.ok(foundCategory.get())
                                         : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@Valid @RequestBody Category category) {
        return  categoryService.save(category);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody Category category) {
        category.setId(id);
        categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }

}
