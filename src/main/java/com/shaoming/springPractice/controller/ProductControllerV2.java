package com.shaoming.springPractice.controller;

import com.shaoming.springPractice.model.Product;
import com.shaoming.springPractice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/products")
public class ProductControllerV2 {
    @Qualifier("productServiceImplV2")
    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id){
        return productService.getById(id);
    }
    @GetMapping("")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id){
        return productService.deleteById(id);
    }

}
