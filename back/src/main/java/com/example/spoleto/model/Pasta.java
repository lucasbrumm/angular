package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductRequestDTO;
import jakarta.persistence.Entity;

@Entity(name = "PASTA")
public class Pasta extends Product {
    public Pasta() {
        super();
    }

    public Pasta(SaveProductRequestDTO saveProductRequestDTO) {
        this.setName(saveProductRequestDTO.name());
        this.setPrice(saveProductRequestDTO.price());
    }
}