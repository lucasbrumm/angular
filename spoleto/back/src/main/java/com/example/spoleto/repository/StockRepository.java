package com.example.spoleto.repository;

import com.example.spoleto.dto.StockInfoProjection;
import com.example.spoleto.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByName(String name);
    @Query(value = "SELECT rel.stock_product_id, rel.quantity, sto.name FROM public.purchase_supplier pur " +
            "JOIN rel_purchase_supplier_stock rel ON rel.purchase_supplier_id = pur.id " +
            "JOIN stock sto ON sto.id = rel.stock_product_id " +
            "WHERE rel.purchase_supplier_id = :purchaseSupplierId", nativeQuery = true)
    List<StockInfoProjection> findStockInfoByPurchaseSupplierId(@Param("purchaseSupplierId") Long purchaseSupplierId);

}
