package com.example.productServices.controllers;

import com.example.productServices.Dtos.ExceptionDto;
import com.example.productServices.exception.CategoryNotFoundException;
import com.example.productServices.models.Category;
import com.example.productServices.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return categoryService.getCategoryById(id);
    }

}
