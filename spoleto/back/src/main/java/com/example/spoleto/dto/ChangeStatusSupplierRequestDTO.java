package com.example.spoleto.dto;

import com.example.spoleto.model.enums.StatusSupplier;

public record ChangeStatusSupplierRequestDTO(Long idSupplier, StatusSupplier statusSupplier) {
}
