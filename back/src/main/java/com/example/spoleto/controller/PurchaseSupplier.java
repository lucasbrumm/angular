package com.example.spoleto.controller;

import com.example.spoleto.model.Stock;
import com.example.spoleto.model.Supplier;
import com.example.spoleto.model.enums.PurchaseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "puchasesupplier")
@Table(name = "purchase_supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PurchaseSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    private LocalDate purchaseDate;

    private BigDecimal totalValue;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "purchase_id")
    private List<Stock> stocks;
}
