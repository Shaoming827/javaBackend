package com.shaoming.springPractice.error;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String id) {
        super("Product id not found : " + id);
    }
}
