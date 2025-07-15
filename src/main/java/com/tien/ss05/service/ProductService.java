package com.tien.ss05.service;

import com.tien.ss05.model.entity.Product;
import com.tien.ss05.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(()->new NoSuchElementException("Khong tim thay san pham"));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, Long id){
        productRepository.findById(id).orElseThrow(()->new NoSuchElementException("Khong tim thay san pham"));
        product.setId(id);
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.findById(id).orElseThrow(()->new NoSuchElementException("Khong tim thay san pham"));
        productRepository.deleteById(id);
    }
}
