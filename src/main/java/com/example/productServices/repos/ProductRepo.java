package com.example.productServices.repos;

import com.example.productServices.models.Product;
import com.example.productServices.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

//    @Query("select p from product p where p.title = :title")
//    List<Product> food(@Param("title") String title);

//    @Query("select p.id as id, p.title as title from Product p where p.title = :title")
//    List<ProductWithIdAndTitle> food2(@Param("title") String title);

    @Query(value = "select p.id as id, p.title as title from Product p where p.title = :title", nativeQuery = true)
    List<ProductWithIdAndTitle> foo(@Param("title") String title);

    List<Product> findAll();

    @Query("select p from Product p where p.category.id = :id")
    List<Product> getProductByCategory(Long id);

}
