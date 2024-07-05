package com.example.spoleto.factory;

import com.example.spoleto.dto.SaveProductRequestDTO;
import com.example.spoleto.model.Ingredient;

public class IngredientFactory implements ProductFactory{
    @Override
    public Ingredient createProduct(SaveProductRequestDTO saveProductRequestDTO) {
        return new Ingredient(saveProductRequestDTO);
    }
}
