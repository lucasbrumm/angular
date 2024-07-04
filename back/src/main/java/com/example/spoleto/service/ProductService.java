package com.example.spoleto.service;

import com.example.spoleto.dto.SaveProductDTO;
import com.example.spoleto.model.Product;
import com.example.spoleto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product saveProduct(SaveProductDTO saveProductDTO) {
        Product product = new Product(saveProductDTO);
        productRepository.save(product);
        return product;
    }
}
