package com.example.spoleto.model.product;

import com.example.spoleto.dto.SaveProductRequestDTO;
import jakarta.persistence.Entity;

@Entity(name = "INGREDIENT")
public class Ingredient extends Product {
    public Ingredient() {
        super();
    }

    public Ingredient(SaveProductRequestDTO saveProductRequestDTO) {
        this.setName(saveProductRequestDTO.name());
        this.setPrice(saveProductRequestDTO.price());
    }
}