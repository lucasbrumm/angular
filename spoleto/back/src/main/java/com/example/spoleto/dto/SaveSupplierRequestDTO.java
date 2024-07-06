package com.example.spoleto.dto;

import com.example.spoleto.model.enums.StatusSupplier;

public record SaveSupplierRequestDTO(String name, String address, String contactNumber, String email, String cnpj,
                                     String description, StatusSupplier status) {
}
