package com.xavier.softgest.service;

import com.xavier.softgest.model.Category;
import com.xavier.softgest.repository.Categories;
import com.xavier.softgest.service.exception.CategoryExistsException;
import com.xavier.softgest.service.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private Categories categories;

    public CategoryService(@Autowired Categories categories) {
        this.categories = categories;
    }

    public Category save(final Category category) {
        verifyIfCategoryExists(category);
       return categories.save(category);
    }

    private void verifyIfCategoryExists(Category category) throws CategoryExistsException {
        Optional<Category> foundCategory = categories.findByName(category.getName());
        if (foundCategory.isPresent() && (category.isNew() || isUpdatingToADifferentCategory(category, foundCategory))) {
            throw new CategoryExistsException();
        }
    }

    private boolean isUpdatingToADifferentCategory(Category category, Optional<Category> foundCategory) {
        return category.exists() && !category.equals(foundCategory.get());
    }

    public void deleteById(Long id) {
        verifyIfCategoryNotExists(id);
        categories.deleteById(id);
    }

    private void verifyIfCategoryNotExists(Long id) throws CategoryNotFoundException {
        Optional<Category> foundCategory = categories.findById(id);
        if(!foundCategory.isPresent()) {
            throw new CategoryNotFoundException();
        }
    }


}
