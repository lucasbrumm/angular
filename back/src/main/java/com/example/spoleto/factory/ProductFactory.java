package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductDTO;
import com.example.spoleto.model.Product;

public interface ProductFactory {
    Product createProduct(SaveProductDTO saveProductDTO);
}
