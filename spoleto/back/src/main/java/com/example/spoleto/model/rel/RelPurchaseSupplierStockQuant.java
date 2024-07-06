package com.example.spoleto.model.rel;

import com.example.spoleto.dto.BuyProductStockFromSupplierRequestDTO;
import com.example.spoleto.model.PurchaseSupplier;
import com.example.spoleto.model.Stock;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "rel_purchase_supplier_stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RelPurchaseSupplierStockQuant {
    @EmbeddedId
    private PurchaseSupplierStockId id;

    @ManyToOne
    @MapsId("purchaseSupplierId")
    @JoinColumn(name = "purchase_supplier_id", nullable = false)
    private PurchaseSupplier purchaseSupplier;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stock_product_id", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private BigDecimal quantity;

    public RelPurchaseSupplierStockQuant(PurchaseSupplier purchaseSupplier, Stock stock, BigDecimal quantity) {
        this.id = new PurchaseSupplierStockId();
        this.purchaseSupplier = purchaseSupplier;
        this.stock = stock;
        this.quantity = quantity;
    }
}
