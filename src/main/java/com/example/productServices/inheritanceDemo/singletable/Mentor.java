package com.example.productServices.inheritanceDemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "single_mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private int rating;
}
