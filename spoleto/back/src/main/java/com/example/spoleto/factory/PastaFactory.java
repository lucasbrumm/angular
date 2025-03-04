package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.model.product.Pasta;
import com.example.spoleto.model.product.Product;

public class PastaFactory implements ProductFactory{
    @Override
    public Product createProduct(SaveProductRequestDTO saveProductRequestDTO) {
        return new Pasta(saveProductRequestDTO);
    }
}
