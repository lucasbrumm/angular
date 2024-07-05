package com.example.spoleto.controller;

import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.exception.ProductNameAlreadyExistsException;
import com.example.spoleto.model.Product;
import com.example.spoleto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/save-product")
    public Product saveProduct(@RequestBody SaveProductRequestDTO saveProductRequestDTO) {
        return productService.saveProduct(saveProductRequestDTO);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/edit/{id}")
    public Product editProduct(@RequestBody EditProductRequestDTO editProductRequestDTO) {
        return productService.editProduct(editProductRequestDTO);
    }
}
