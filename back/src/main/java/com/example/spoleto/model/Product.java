package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductDTO;
import com.example.spoleto.dto.SaveProductStockDTO;
import com.example.spoleto.model.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "product")
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    private String price;

    public Product(SaveProductDTO saveProductDTO) {
        this.price = saveProductDTO.price();
        this.name = saveProductDTO.name();
    }
}
