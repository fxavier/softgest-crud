package com.xavier.softgest.service;

import com.xavier.softgest.model.Product;
import com.xavier.softgest.repository.Products;
import com.xavier.softgest.service.exception.ProductExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @Mock
    private Products mockedProduct;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(mockedProduct);
    }

    @Test
    void should_denayToSaveProductThatExists() {
        Product productInDatabase = new Product();
        productInDatabase.setId(1L);
        productInDatabase.setName("TV LG");

        when(mockedProduct.findByName("TV LG")).thenReturn(Optional.of(productInDatabase));

        Product newProduct = new Product();
        newProduct.setId(2L);
        newProduct.setName("TV LG");

       assertThrows(ProductExistException.class, () -> {
           productService.save(newProduct);
       });


    }

    @Test
    void save() {
        Product product = new Product();

        given(mockedProduct.save(any(Product.class))).willReturn(product);

        Product savedProduct = productService.save(new Product());

        then(mockedProduct).should().save(any(Product.class));
        assertThat(savedProduct).isNotNull();
    }

    @Test
    void deleteById() {

    }
}