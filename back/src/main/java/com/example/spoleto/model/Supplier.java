package com.example.spoleto.model;

import com.example.spoleto.dto.SaveSupplierRequestDTO;
import com.example.spoleto.model.enums.StatusSupplier;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "supplier")
@Table(name = "supplier")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @Column(name = "contact_number", nullable = false, length = 12)
    private String contactNumber;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "cnpj", unique = true, nullable = false, length = 18)
    private String cnpj;
    private String description;
    @Enumerated(EnumType.STRING)
    private StatusSupplier status;

    public Supplier(SaveSupplierRequestDTO saveSupplierRequestDTO) {
        this.name = saveSupplierRequestDTO.name();
        this.address = saveSupplierRequestDTO.address();
        this.contactNumber = saveSupplierRequestDTO.contactNumber();
        this.email = saveSupplierRequestDTO.email();
        this.cnpj = saveSupplierRequestDTO.cnpj();
        this.description = saveSupplierRequestDTO.description();
        this.status = saveSupplierRequestDTO.status();
    }
}
