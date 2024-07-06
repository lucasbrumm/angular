package com.example.spoleto.repository;

import com.example.spoleto.model.PurchaseSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseSupplierRepository extends JpaRepository<PurchaseSupplier, Long> {
}
