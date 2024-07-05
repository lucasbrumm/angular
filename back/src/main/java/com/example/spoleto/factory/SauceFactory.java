package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductDTO;
import com.example.spoleto.model.Pasta;
import com.example.spoleto.model.Product;
import com.example.spoleto.model.Sauce;

public class SauceFactory implements ProductFactory{
    @Override
    public Sauce createProduct(SaveProductDTO saveProductDTO) {
        return new Sauce(saveProductDTO);
    }
}
