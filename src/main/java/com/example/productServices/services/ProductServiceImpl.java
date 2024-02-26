package com.example.productServices.services;

import com.example.productServices.exception.CategoryNotFoundException;
import com.example.productServices.exception.ProductNotFoundException;
import com.example.productServices.models.Category;
import com.example.productServices.models.Product;
import com.example.productServices.repos.CategoryRepo;
import com.example.productServices.repos.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public ProductServiceImpl(
            ProductRepo productRepo,
            CategoryRepo categoryRepo
    ) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findById(id);
        if(product.isEmpty()) {
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        return product.get();
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductByCategory(Long id) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if(optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category not found with id : " + id);
        }
        return productRepo.getProductByCategory(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        Product existingProduct = optionalProduct.get();
        setProductAllFields(existingProduct, product);
        return productRepo.save(existingProduct);
    }

    @Override
    public Product deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        productRepo.deleteById(id);
        return optionalProduct.get();
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Category> optionalCategory = categoryRepo.findByName(product.getCategory().getName());
        if (optionalCategory.isEmpty()) {
            Category category = categoryRepo.save(product.getCategory());
            product.setCategory(category);
        } else {
            product.setCategory(optionalCategory.get());
        }
        return productRepo.save(product);
    }

    private void setProductAllFields(Product existingProduct, Product product) {
        existingProduct.setCategory(product.getCategory());
        existingProduct.setTitle(product.getTitle());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setRating(product.getRating());
        existingProduct.setQuantity(product.getQuantity());
    }
}
