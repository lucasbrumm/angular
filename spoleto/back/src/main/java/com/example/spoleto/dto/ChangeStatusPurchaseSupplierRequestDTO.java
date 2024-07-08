package com.example.spoleto.dto;

import com.example.spoleto.model.enums.PurchaseStatus;
import com.example.spoleto.model.enums.StatusSupplier;

public record ChangeStatusPurchaseSupplierRequestDTO(Long idSupplierPurchase, PurchaseStatus statusPurchase) {
}
