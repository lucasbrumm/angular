package com.example.spoleto.model.rel;

import com.example.spoleto.model.OrderClient;
import com.example.spoleto.model.PurchaseSupplier;
import com.example.spoleto.model.Stock;
import com.example.spoleto.model.product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "rel_order_client_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RelOrderClientProductQuant {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id", nullable = false)
    private OrderClient orderClient;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private BigDecimal quantity;

    public RelOrderClientProductQuant(Product product, OrderClient orderClient, BigDecimal quantity) {
        this.id = new OrderProductId();
        this.product = product;
        this.orderClient = orderClient;
        this.quantity = quantity;
    }
}
