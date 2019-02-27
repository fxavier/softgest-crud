package com.xavier.softgest.service;

import com.xavier.softgest.model.Brand;
import com.xavier.softgest.repository.Brands;
import com.xavier.softgest.service.exception.BrandExistsException;
import com.xavier.softgest.service.exception.BrandNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BrandServiceTest {
    private BrandService brandService;

    @Mock
    private Brands mockedBrand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        brandService = new BrandService(mockedBrand);
    }


    @Test
    void should_denyBrandThatExists() {
        Brand brandInDatabase = new Brand();
        brandInDatabase.setId(2L);
        brandInDatabase.setName("Apple");

        when(mockedBrand.findByName("Apple")).thenReturn(Optional.of(brandInDatabase));

        Brand newBrand = new Brand();
        newBrand.setId(5L);
        newBrand.setName("Apple");

        assertThrows(BrandExistsException.class, () -> {
            brandService.save(newBrand);
        });
    }

    @Test
    void should_createBrand() {
        Brand brand = new Brand();

        given(mockedBrand.save(any(Brand.class))).willReturn(brand);

        Brand savedBrand = brandService.save(new Brand());

        then(mockedBrand).should().save(any(Brand.class));

        assertThat(savedBrand).isNotNull();
    }

    @Test
    void shouldNot_deleteBrandThatDoesNotExists() {
       assertThrows(BrandNotFoundException.class, () -> {

        brandService.deleteById(1L);
       });

       // then(mockedBrand).should().deleteById(1L);
    }
}