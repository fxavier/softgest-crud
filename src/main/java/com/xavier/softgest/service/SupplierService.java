package com.xavier.softgest.service;

import com.xavier.softgest.model.Supplier;
import com.xavier.softgest.repository.Suppliers;
import com.xavier.softgest.service.exception.SupplierExistException;
import com.xavier.softgest.service.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {

    private Suppliers suppliers;

    public SupplierService(@Autowired Suppliers suppliers) {
        this.suppliers = suppliers;
    }

    public Supplier save(final Supplier supplier) {
        verifyIfExists(supplier);
        return suppliers.save(supplier);
    }

    public Supplier findById(Long id) {
        verifyIfNotExist(id);
        return suppliers.getOne(id);
    }

    public void deleteById(Long id) {
        verifyIfNotExist(id);
    }

    private void verifyIfNotExist(Long id) throws SupplierNotFoundException {
        Optional<Supplier> foundSupplier = suppliers.findById(id);
        if (!foundSupplier.isPresent()) {
            throw new SupplierNotFoundException();
        }
    }

    private void verifyIfExists(Supplier supplier) throws SupplierExistException {
        Optional<Supplier> foundSupplier = suppliers.findBySupplierName(supplier.getSupplierName());
        if (foundSupplier.isPresent() && (supplier.isNew() || isUpdatingToADifferentEntity(supplier, foundSupplier))) {
            throw new SupplierExistException();
        }
    }

    private boolean isUpdatingToADifferentEntity(Supplier supplier, Optional<Supplier> foundSupplier) {
        return supplier.exists() && !supplier.equals(foundSupplier.get());
    }

}
