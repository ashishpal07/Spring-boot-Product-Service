package com.example.productServices.controllers;

import com.example.productServices.Dtos.ExceptionDto;
import com.example.productServices.exception.CategoryNotFoundException;
import com.example.productServices.exception.ProductNotFoundException;
import com.example.productServices.models.Category;
import com.example.productServices.models.Product;
import com.example.productServices.services.CategoryService;
import com.example.productServices.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(
            @Qualifier("ProductService") ProductService productService
    ) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @DeleteMapping("/{id}")
    public Product deleteProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.deleteProduct(id);
    }

    @GetMapping("/categories/{id}")
    public List<Product> getProductByCategory(@PathVariable("id") Long id) throws CategoryNotFoundException {
        return productService.getProductByCategory(id);
    }

    @PutMapping("/{id}")
    public Product updateProductById(
            @PathVariable("id") Long id,
            @RequestBody Product product
    ) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

}
