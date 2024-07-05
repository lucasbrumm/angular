package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductDTO;
import com.example.spoleto.model.Ingredient;
import com.example.spoleto.model.Pasta;
import com.example.spoleto.model.Product;

public class IngredientFactory implements ProductFactory{
    @Override
    public Ingredient createProduct(SaveProductDTO saveProductDTO) {
        return new Ingredient(saveProductDTO);
    }
}
