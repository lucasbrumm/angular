package com.example.spoleto.repository;

import com.example.spoleto.model.rel.PurchaseSupplierStockId;
import com.example.spoleto.model.rel.RelPurchaseSupplierStockQuant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelPurchaseSupplierStockQuantRepository extends JpaRepository<RelPurchaseSupplierStockQuant, PurchaseSupplierStockId> {
}
