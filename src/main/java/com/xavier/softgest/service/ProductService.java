package com.xavier.softgest.service;

import com.xavier.softgest.model.Product;
import com.xavier.softgest.repository.Products;
import com.xavier.softgest.service.exception.ProductExistException;
import com.xavier.softgest.service.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private Products products;

    public ProductService(@Autowired Products products) {
        this.products = products;
    }

    public Product save(final Product product) {
        verifyIfExists(product);
        return products.save(product);
    }

    public void deleteById(Long id) {
        verifyIfNotExist(id);
        products.deleteById(id);
    }

    private void verifyIfNotExist(Long id) {
        Optional<Product> foundProduct = products.findById(id);
        if (!foundProduct.isPresent()) {
            throw new ProductNotFoundException();
        }
    }

    private void verifyIfExists(Product product) throws ProductExistException {
        Optional<Product> foundProduct = products.findByName(product.getName());
        if (foundProduct.isPresent()) {
            throw new ProductExistException();
        }
    }

    private boolean isUpdatingToADifferentEntity(Product product, Optional<Product> foundProduct) {
        return product.exists() && !product.equals(foundProduct.get());
    }
}
