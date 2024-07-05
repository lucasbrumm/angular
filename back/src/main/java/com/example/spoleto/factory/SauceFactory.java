package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.model.Sauce;

public class SauceFactory implements ProductFactory{
    @Override
    public Sauce createProduct(SaveProductRequestDTO saveProductDTO) {
        return new Sauce(saveProductDTO);
    }
}
