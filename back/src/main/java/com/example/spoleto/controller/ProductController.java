package com.example.spoleto.controller;

import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.model.Product;
import com.example.spoleto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/get-all-products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping("/save-product")
    public Product saveProduct(@RequestBody SaveProductRequestDTO saveProductRequestDTO) {
        return productService.saveProduct(saveProductRequestDTO);
    }
}
