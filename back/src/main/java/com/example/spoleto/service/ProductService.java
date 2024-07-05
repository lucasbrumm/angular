package com.example.spoleto.service;

import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.factory.IngredientFactory;
import com.example.spoleto.factory.PastaFactory;
import com.example.spoleto.factory.ProductFactory;
import com.example.spoleto.factory.SauceFactory;
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

    public Product saveProduct(SaveProductRequestDTO saveProductRequestDTO) {
        Product product = selectClass(saveProductRequestDTO);
        productRepository.save(product);
        return product;
    }

    private Product selectClass(SaveProductRequestDTO saveProductDTO) {
        ProductFactory factory;
        switch (saveProductDTO.productType()) {
            case PASTA:
                factory = new PastaFactory();
                break;
            case SAUCE:
                factory = new SauceFactory();
                break;
            case INGREDIENT:
                factory = new IngredientFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid product type");
        }
        return factory.createProduct(saveProductDTO);
    }
}
