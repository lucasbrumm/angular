package com.example.spoleto.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "stock")
@Table(name = "stock")
@Data
public class Stock {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;

    private Integer quantity;
}
