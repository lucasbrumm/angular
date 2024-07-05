package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductDTO;
import com.example.spoleto.model.Pasta;
import com.example.spoleto.model.Product;

public class PastaFactory implements ProductFactory{
    @Override
    public Product createProduct(SaveProductDTO saveProductDTO) {
        return new Pasta(saveProductDTO);
    }
}
