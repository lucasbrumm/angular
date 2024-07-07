package com.example.spoleto.dto;

import com.example.spoleto.model.enums.PurchaseStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record BuyProductStockFromSupplierRequestDTO(Long idSupplier, List<ProductPurchase> purchases) {
    public record ProductPurchase(Long productId, BigDecimal quantity) {
    }
}
