package com.example.spoleto.dto;

import com.example.spoleto.model.enums.ProductType;

import java.math.BigDecimal;

public record SaveProductStockDTO(String name, BigDecimal cost, BigDecimal quantity, ProductType productType) {
}
