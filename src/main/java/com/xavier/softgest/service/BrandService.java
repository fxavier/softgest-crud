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

    public Brand findOne(Long id) {
        verifyIfNotExists(id);
        return brands.getOne(id);
    }

    public Brand save(final Brand brand) {
        verifyIfBrandExists(brand);
        return brands.save(brand);
    }

    public void deleteById(Long id) {
        verifyIfNotExists(id);
        brands.deleteById(id);
    }

    private void verifyIfNotExists(Long id) {
        Optional<Brand> foundBrand = brands.findById(id);
        if (!foundBrand.isPresent()) {
            throw new BrandNotFoundException();
        }
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

}
