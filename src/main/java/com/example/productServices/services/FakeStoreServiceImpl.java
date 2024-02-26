package com.example.productServices.services;

import com.example.productServices.Dtos.FakeProductDto;
import com.example.productServices.exception.ProductNotFoundException;
import com.example.productServices.models.Category;
import com.example.productServices.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreService")
public class FakeStoreServiceImpl implements ProductService {

    RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public FakeStoreServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private final String specificUrl = "https://fakestoreapi.com/products/{id}";
    private final String getProductsUrl = "https://fakestoreapi.com/products";

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeProductDto> response =
                restTemplate.getForEntity(specificUrl, FakeProductDto.class, id);
        if(response.getBody() == null) {
            throw new ProductNotFoundException("Product not found with id : " + id);
        }
        return this.getProductFromFakeStoreProductDto(response.getBody());
    }

    @Override
    public List<Product> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeProductDto[]> response =
                restTemplate.getForEntity(getProductsUrl, FakeProductDto[].class);

        List<Product> products = new ArrayList<>();
        if(response.getBody() == null) {
            return null;
        }
        for(FakeProductDto fakeProductDto: response.getBody()) {
            products.add(this.getProductFromFakeStoreProductDto(fakeProductDto ));
        }
        return products;
    }

    @Override
    public List<Product> getProductByCategory(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product Product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    private Product getProductFromFakeStoreProductDto(FakeProductDto fakeProductDto) {
        Product product = new Product();
        Category category = new Category();
        category.setName(fakeProductDto.getCategory());
        product.setCategory(category);
        product.setPrice(fakeProductDto.getPrice());
        product.setTitle(fakeProductDto.getTitle());
        product.setId(fakeProductDto.getId());
        product.setDescription(fakeProductDto.getDescription());
        return product;
    }
}
