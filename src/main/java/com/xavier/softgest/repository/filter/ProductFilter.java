package com.xavier.softgest.repository.filter;

import com.xavier.softgest.model.Category;
import com.xavier.softgest.model.Subcategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFilter {

    private String sku;

    private String name;

    private Category category;

    private Subcategory subcategory;



}
