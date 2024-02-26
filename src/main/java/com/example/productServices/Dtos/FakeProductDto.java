package com.example.productServices.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FakeProductDto {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Long price;
}
