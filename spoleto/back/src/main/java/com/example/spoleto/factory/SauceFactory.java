package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.model.product.Sauce;

public class SauceFactory implements ProductFactory{
    @Override
    public Sauce createProduct(SaveProductRequestDTO saveProductRequestDTO) {
        return new Sauce(saveProductRequestDTO);
    }
}
