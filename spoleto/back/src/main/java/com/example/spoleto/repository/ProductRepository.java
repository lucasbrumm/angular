package com.example.spoleto.repository;

import com.example.spoleto.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);


    Optional<Product> findByPrice(String price);

}
