package com.example.spoleto.dto;

import com.example.spoleto.model.enums.ProductType;

public record SaveProductStockDTO(String name, String cost, Integer quantity, ProductType productType) {
}
