package com.example.spoleto.model;

import com.example.spoleto.dto.SaveProductRequestDTO;
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

    public Product(SaveProductRequestDTO saveProductRequestDTO) {
        this.price = saveProductRequestDTO.price();
        this.name = saveProductRequestDTO.name();
    }
}
