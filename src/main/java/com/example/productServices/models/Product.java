package com.example.productServices.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private int quantity;
    private Long price;
    private int rating;
}
