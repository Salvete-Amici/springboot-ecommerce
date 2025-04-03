package com.ecommerce.springboot.service;

import com.ecommerce.springboot.payload.CategoryDTO;
import com.ecommerce.springboot.payload.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTo, Long categoryId);
}
