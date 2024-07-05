package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductDTO;
import jakarta.persistence.Entity;

@Entity(name = "ingredient")
public class Ingredient extends Product {
    public Ingredient() {
        super();
    }

    public Ingredient(SaveProductDTO saveProductDTO) {
        this.setName(saveProductDTO.name());
        this.setPrice(saveProductDTO.price());
    }
}