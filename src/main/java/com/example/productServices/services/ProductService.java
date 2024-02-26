package com.example.productServices.services;

import com.example.productServices.exception.CategoryNotFoundException;
import com.example.productServices.exception.ProductNotFoundException;
import com.example.productServices.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;

    List<Product> getProducts();

    List<Product> getProductByCategory(Long id) throws CategoryNotFoundException;

    Product updateProduct(Long id, Product Product) throws ProductNotFoundException;

    Product deleteProduct(Long id) throws ProductNotFoundException;

    Product addProduct(Product product);

}
