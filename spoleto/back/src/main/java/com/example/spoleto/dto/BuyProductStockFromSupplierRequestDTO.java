package com.example.spoleto.dto;

import java.math.BigDecimal;
import java.util.List;

public record BuyProductStockFromSupplierRequestDTO(Long idSupplier, List<ProductPurchase> purchases) {
    public record ProductPurchase(Long productId, BigDecimal quantity) {
    }
}
