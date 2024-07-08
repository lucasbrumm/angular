package com.example.spoleto.model;

import com.example.spoleto.dto.BuyProductStockFromSupplierRequestDTO;
import com.example.spoleto.model.enums.PurchaseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyProductStockFromSupplierResponse {
    private Long purchaseId;
    private LocalDate purchaseDate;
    private PurchaseStatus purchaseStatus;
    private BigDecimal totalValue;
    private List listProducts;

    public BuyProductStockFromSupplierResponse(PurchaseSupplier purchaseSupplier, List itensRelation) {
        this.purchaseId = purchaseSupplier.getId();
        this.purchaseDate = purchaseSupplier.getPurchaseDate();
        this.purchaseStatus = purchaseSupplier.getStatus();
        this.totalValue = purchaseSupplier.getTotalValue();
        this.listProducts = itensRelation;
    }

}
