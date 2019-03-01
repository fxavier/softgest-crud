package com.xavier.softgest.service;

import com.xavier.softgest.model.Category;
import com.xavier.softgest.repository.Categories;
import com.xavier.softgest.service.exception.CategoryExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

class CategoryServiceTest {

    private CategoryService categoryService;

    @Mock
    private Categories mockedCategory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryService(mockedCategory);
    }

    @Test
    void should_notSaveCategoryThatExists() {
        Category categoryInDatabase = new Category();
        categoryInDatabase.setId(1L);
        categoryInDatabase.setName("Fashion");

        when(mockedCategory.findByName("Fashion")).thenReturn(Optional.of(categoryInDatabase));

        Category newCategory = new Category();
        newCategory.setId(2L);
        newCategory.setName("Fashion");

        assertThrows(CategoryExistsException.class, () -> {
            categoryService.save(newCategory);
        });
    }

    @Test
    void save() {
        Category category = new Category();

        given(mockedCategory.save(any(Category.class))).willReturn(category);

        Category savedCategory = categoryService.save(new Category());

        then(mockedCategory).should().save(any(Category.class));

        assertThat(savedCategory).isNotNull();
    }

    @Test
    void deleteById() {
    }


}