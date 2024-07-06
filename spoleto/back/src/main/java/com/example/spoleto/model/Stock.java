package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductStockDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "stock")
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "cost", nullable = false, precision = 19, scale = 2)
    private BigDecimal cost;
    @Column(name = "quantity", precision = 19, scale = 2)
    private BigDecimal quantity = BigDecimal.ZERO;
    public Stock(SaveProductStockDTO saveProductStockDTO) {
        this.name = saveProductStockDTO.name();
        this.cost = saveProductStockDTO.cost();
        this.quantity = saveProductStockDTO.quantity();
    }
}
