package com.xavier.softgest.service;

import com.xavier.softgest.model.Brand;
import com.xavier.softgest.repository.Brands;
import com.xavier.softgest.service.exception.BrandExistsException;
import com.xavier.softgest.service.exception.BrandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {

    private Brands brands;

    public BrandService(@Autowired Brands brands) {
        this.brands = brands;
    }

    public Brand save(final Brand brand) {
        verifyIfBrandExists(brand);
        return brands.save(brand);
    }

    private void verifyIfBrandExists(Brand brand) {
        Optional<Brand> foundBrand = brands.findByName(brand.getName());
        if (foundBrand.isPresent() && (brand.isNew() || isUpdatingToADifferentBrand(brand, foundBrand))) {
            throw new BrandExistsException();
        }
    }

    private boolean isUpdatingToADifferentBrand(Brand brand, Optional<Brand> foundBrand) {
        return brand.exists() && !brand.equals(foundBrand.get());
    }

    public void deleteById(Long id) {
        Optional<Brand> foundBrand = brands.findById(id);
        if (!foundBrand.isPresent()) {
            throw new BrandNotFoundException();
        }

        brands.deleteById(id);
    }
}
