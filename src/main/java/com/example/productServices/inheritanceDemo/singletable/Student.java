package com.example.productServices.inheritanceDemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "single_student")
@Getter
@Setter
@DiscriminatorValue(value = "1")
public class Student extends User {
    private int psp;
    private String batch;

}
