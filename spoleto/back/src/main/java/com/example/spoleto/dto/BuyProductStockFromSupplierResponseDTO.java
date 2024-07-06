package com.example.spoleto.dto;

import com.example.spoleto.model.enums.PurchaseStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BuyProductStockFromSupplierResponseDTO(Long purchaseId, LocalDate purchaseDate, PurchaseStatus purchaseStatus,
                                                     BigDecimal totalValue, BuyProductStockFromSupplierRequestDTO listProducts) {
}
