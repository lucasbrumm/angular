package com.example.spoleto.dto;

import java.math.BigDecimal;

public record EditProductRequestDTO(Long id, String name, BigDecimal price) {
}
