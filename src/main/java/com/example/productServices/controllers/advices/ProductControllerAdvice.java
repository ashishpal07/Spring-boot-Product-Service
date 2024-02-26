package com.example.productServices.controllers.advices;

import com.example.productServices.Dtos.ExceptionDto;
import com.example.productServices.exception.CategoryNotFoundException;
import com.example.productServices.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException e) {
        ExceptionDto exception = new ExceptionDto();
        exception.setMessage(e.getMessage());
        exception.setStatus("Failure");
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(CategoryNotFoundException e) {
        ExceptionDto exception = new ExceptionDto();
        exception.setMessage(e.getMessage());
        exception.setStatus("Failure");
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
