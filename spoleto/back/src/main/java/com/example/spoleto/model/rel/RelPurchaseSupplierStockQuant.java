package com.example.spoleto.model.rel;

import com.example.spoleto.model.PurchaseSupplier;
import com.example.spoleto.model.Stock;
import jakarta.persistence.*;
import lombok.*;

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
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    @Column(nullable = false)
    private Integer quantity;
}
