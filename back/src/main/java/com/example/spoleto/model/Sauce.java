package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductDTO;
import com.example.spoleto.model.enums.ProductType;
import jakarta.persistence.Entity;

@Entity(name = "sauce")
public class Sauce extends Product {
    public Sauce() {
        super();
    }

    public Sauce(SaveProductDTO saveProductDTO) {
        this.setName(saveProductDTO.name());
        this.setPrice(saveProductDTO.price());
    }
}