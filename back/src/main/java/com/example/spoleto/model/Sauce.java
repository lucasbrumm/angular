package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductRequestDTO;
import jakarta.persistence.Entity;

@Entity(name = "SAUCE")
public class Sauce extends Product {
    public Sauce() {
        super();
    }

    public Sauce(SaveProductRequestDTO saveProductRequestDTO) {
        this.setName(saveProductRequestDTO.name());
        this.setPrice(saveProductRequestDTO.price());
    }
}