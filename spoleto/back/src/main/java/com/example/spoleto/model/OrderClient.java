package com.example.spoleto.model;

import com.example.spoleto.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "orderclient")
@Table(name = "order_client")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    private BigDecimal totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderClient() {
        this.orderDate = LocalDate.now();
        this.orderStatus = OrderStatus.PENDING;
    }
}
