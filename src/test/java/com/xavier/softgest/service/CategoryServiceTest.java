package com.xavier.softgest.service;

import com.xavier.softgest.model.Category;
import com.xavier.softgest.repository.Categories;
import com.xavier.softgest.service.exception.CategoryExistsException;
import com.xavier.softgest.service.exception.CategoryNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryServiceTest {

    private CategoryService categoryService;

    @Mock
    private Categories mockedCategory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryService(mockedCategory);

    }

    @Test(expected = CategoryExistsException.class)
    public void should_denyExistingCategory() {
        Category categoryInDatabase = new Category();
        categoryInDatabase.setId(10L);
        categoryInDatabase.setName("Electronics");

        when(mockedCategory.findByName("Electronics")).thenReturn(Optional.of(categoryInDatabase));

        Category newCategory = new Category();
        newCategory.setId(15L);
        newCategory.setName("Electronics");

        categoryService.save(newCategory);

    }

    @Test
    public void should_saveCategory() {
        Category category = new Category();

        given(mockedCategory.save(any(Category.class))).willReturn(category);

        Category savedCategory = categoryService.save(new Category());

        then(mockedCategory).should().save(any(Category.class));
        assertThat(savedCategory).isNotNull();
    }

    @Test(expected = CategoryNotFoundException.class)
    public void should_notDeleteByIdThatNotFound() {
       categoryService.deleteById(anyLong());
       verify(mockedCategory).deleteById(anyLong());
    }

}
