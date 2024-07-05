package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.model.Product;

public interface ProductFactory {
    Product createProduct(SaveProductRequestDTO saveProductDTO);
}
