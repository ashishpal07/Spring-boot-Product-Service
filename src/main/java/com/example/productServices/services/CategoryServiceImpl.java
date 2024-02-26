package com.example.productServices.services;

import com.example.productServices.exception.CategoryNotFoundException;
import com.example.productServices.models.Category;
import com.example.productServices.repos.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category addCategory(String name) {
        Optional<Category> optionalCategory = categoryRepo.findByName(name);
        if(optionalCategory.isEmpty()) {
            Category category = new Category();
            category.setName(category.getName());
            return categoryRepo.save(category);
        } else {
            return optionalCategory.get();
        }
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category not found with id : " + id);
        }
        return optionalCategory.get();
    }
}
