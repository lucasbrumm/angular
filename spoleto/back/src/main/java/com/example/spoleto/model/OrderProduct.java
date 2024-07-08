package com.example.spoleto.model;

import com.example.spoleto.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "orderproduct")
@Table(name = "order_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    private BigDecimal totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
