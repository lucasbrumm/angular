package com.example.spoleto.dto;

import com.example.spoleto.model.enums.ProductType;

import java.math.BigDecimal;

public record SaveProductRequestDTO(String name, BigDecimal price, ProductType productType){
}
