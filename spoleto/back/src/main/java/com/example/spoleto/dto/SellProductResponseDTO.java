package com.example.spoleto.dto;

import com.example.spoleto.model.OrderClient;
import com.example.spoleto.model.PurchaseSupplier;
import com.example.spoleto.model.enums.OrderStatus;
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
public class SellProductResponseDTO {
    private Long orderId;
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private BigDecimal totalPrice;
    private List<?> listProducts;

    public SellProductResponseDTO(OrderClient orderClient, List itensRelation) {
        this.orderId = orderClient.getId();
        this.orderDate = orderClient.getOrderDate();
        this.orderStatus = orderClient.getOrderStatus();
        this.totalPrice = orderClient.getTotalPrice();
        this.listProducts = itensRelation;
    }
}
