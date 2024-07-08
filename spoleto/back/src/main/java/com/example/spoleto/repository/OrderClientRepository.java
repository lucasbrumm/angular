package com.example.spoleto.repository;

import com.example.spoleto.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderClientRepository extends JpaRepository<OrderClient, Long> {
}
