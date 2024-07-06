package com.example.spoleto.model.rel;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PurchaseSupplierStockId implements Serializable {
    private Long purchaseSupplierId;
    private Long stockId;
}
