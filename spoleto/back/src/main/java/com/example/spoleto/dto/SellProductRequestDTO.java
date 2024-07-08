package com.example.spoleto.dto;

import com.example.spoleto.model.product.Product;

import java.math.BigDecimal;
import java.util.List;

public record SellProductRequestDTO(List<OrderClient> productList) {
    public record OrderClient(Product product, BigDecimal quantity) {
    }
}
