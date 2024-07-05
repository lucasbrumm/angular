package com.example.spoleto.service;

import com.example.spoleto.dto.EditProductRequestDTO;
import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.exception.ProductNameAlreadyExistsException;
import com.example.spoleto.factory.IngredientFactory;
import com.example.spoleto.factory.PastaFactory;
import com.example.spoleto.factory.ProductFactory;
import com.example.spoleto.factory.SauceFactory;
import com.example.spoleto.model.Product;
import com.example.spoleto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow();
        product.setDtype(getDType(product));
        return product;
    }

    public Product saveProduct(SaveProductRequestDTO saveProductRequestDTO) {
        if (productRepository.findByName(saveProductRequestDTO.name()).isPresent()) {
            throw new ProductNameAlreadyExistsException("Product with name " + saveProductRequestDTO.name() + " already exists.");
        }
        Product product = selectClass(saveProductRequestDTO);
        product.setDtype(getDType(product));
        productRepository.save(product);
        return product;
    }

    public Product editProduct(EditProductRequestDTO editProductRequestDTO) {
        Optional<Product> optionalProduct = productRepository.findById(editProductRequestDTO.id());
        if (optionalProduct.isEmpty()) {
            throw new ProductNameAlreadyExistsException("Product with id " + editProductRequestDTO.id() + " not exists.");
        }
        Product editedProduct = productRepository.findById(editProductRequestDTO.id()).orElseThrow();
        if(productRepository.findByName(editProductRequestDTO.name()).isPresent()) {
            throw new ProductNameAlreadyExistsException("Product with name " + editProductRequestDTO.name() + " already exists.");
        }
        editedProduct.setName(editProductRequestDTO.name());
        editedProduct.setPrice(editProductRequestDTO.price());
        productRepository.save(editedProduct);
        editedProduct.setDtype(getDType(editedProduct));
        return editedProduct;
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

    private String getDType(Product product) {
        return product.getClass().getSimpleName().toUpperCase();
    }
}
