package com.shaoming.springPractice.service;

import com.shaoming.springPractice.entity.ProductEntity;
import com.shaoming.springPractice.model.Product;
import com.shaoming.springPractice.repository.ProductRepository;
import com.zaxxer.hikari.util.PropertyElf;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplV2 implements ProductService{
    //use default implementation of JpaRepository
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product save(Product product) {
        if(product.getProductId() == null){
            product.setProductId(UUID.randomUUID().toString());
        }
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(product, productEntity);
        productRepository.save(productEntity);
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream()
                .map(productEntity -> {
                    Product product = new Product();
                    BeanUtils.copyProperties(productEntity, product);
                    return product;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Product getById(String id) {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        if(productEntity != null){
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            return product;
        }
        return null;
    }

    @Override
    public String deleteById(String id) {
        productRepository.deleteById(id);
        return "Product deleted successfully with: "   + id+" by JPA H2";
    }
}
