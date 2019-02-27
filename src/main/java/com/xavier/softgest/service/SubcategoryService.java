package com.xavier.softgest.service;

import com.xavier.softgest.model.Subcategory;
import com.xavier.softgest.repository.Subcategories;
import com.xavier.softgest.service.exception.SubcategoryExistException;
import com.xavier.softgest.service.exception.SubcategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubcategoryService {

    private Subcategories subcategories;

    public SubcategoryService(@Autowired Subcategories subcategories) {
        this.subcategories = subcategories;
    }

    public Subcategory save(final Subcategory subcategory) {
        verifyIfExists(subcategory);
        return subcategories.save(subcategory);
    }

    public void deleteById(Long id) {
        verifyIfNotExists(id);
        subcategories.deleteById(id);
    }

    private void verifyIfNotExists(Long id) throws SubcategoryNotFoundException {
        Optional<Subcategory> foundSubcategory = subcategories.findById(id);
        if (!foundSubcategory.isPresent()) {
            throw new SubcategoryNotFoundException();
        }
    }

    private void verifyIfExists(Subcategory subcategory) throws SubcategoryExistException {
        Optional<Subcategory> foundSubcategory = subcategories.findByName(subcategory.getName());
        if (foundSubcategory.isPresent() && (subcategory.isNew() || isUpdatingToADifferentSubcategory(subcategory, foundSubcategory))) {
            throw new SubcategoryExistException();
        }

    }

    private boolean isUpdatingToADifferentSubcategory(Subcategory subcategory, Optional<Subcategory> foundSubcategory) {
        return subcategory.exists() && !subcategory.equals(foundSubcategory.get());
    }


}
