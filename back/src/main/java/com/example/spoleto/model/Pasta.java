package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductDTO;
import com.example.spoleto.model.enums.ProductType;
import jakarta.persistence.Entity;

@Entity(name = "pasta")
public class Pasta extends Product {
    public Pasta() {
        super();
    }

    public Pasta(SaveProductDTO saveProductDTO) {
        this.setName(saveProductDTO.name());
        this.setPrice(saveProductDTO.price());
    }
}