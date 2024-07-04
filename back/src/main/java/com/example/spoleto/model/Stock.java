package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductStockDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "stock")
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Stock {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;
    private String cost;
    private Integer quantity;

    public Stock(SaveProductStockDTO saveProductStockDTO) {
        this.product = new Product(saveProductStockDTO);
        this.cost = saveProductStockDTO.cost();
        this.quantity = saveProductStockDTO.quantity();
    }
}
