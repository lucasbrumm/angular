package com.example.spoleto.repository;

import com.example.spoleto.model.rel.OrderProductId;
import com.example.spoleto.model.rel.RelOrderClientProductQuant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelOrderClientProductQuantRepository extends JpaRepository<RelOrderClientProductQuant, OrderProductId> {
}
