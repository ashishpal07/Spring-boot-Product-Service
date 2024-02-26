package com.example.productServices.services;

import com.example.productServices.exception.CategoryNotFoundException;
import com.example.productServices.models.Category;

public interface CategoryService {

    public Category addCategory(String name);

    public Category getCategoryById(Long id) throws CategoryNotFoundException;

}
