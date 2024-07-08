package com.example.spoleto.dto;

import java.math.BigDecimal;

public interface StockInfoProjection {
    Long getStockProductId();
    BigDecimal getQuantity();
    String getName();
}
