package com.xavier.softgest.repository.helper.product;

import com.xavier.softgest.model.Product;
import com.xavier.softgest.repository.filter.ProductFilter;
import org.springframework.data.domain.Page;

public interface ProductQueries {

    public Page<Product> filter(ProductFilter filter);
}
