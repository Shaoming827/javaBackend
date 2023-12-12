package com.shaoming.springPractice.service;

import com.shaoming.springPractice.error.ProductNotFoundException;
import com.shaoming.springPractice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class ProductServiceImpl implements ProductService{
    List<Product> productList = new ArrayList<>();
    @Override
    public Product save(Product product) {
        if(product.getProductId() == null){
            product.setProductId(UUID.randomUUID().toString());
        }
        productList.add(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getById(String id) {
        return productList.stream().filter(product -> product.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    @Override
    public String deleteById(String id) {
        Product product = productList.stream().filter(product1 -> product1.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("General Exception"));
        return productList.remove(product) ? "Product with id " + id+ " has been deleted" : "Failed";
    }
}
