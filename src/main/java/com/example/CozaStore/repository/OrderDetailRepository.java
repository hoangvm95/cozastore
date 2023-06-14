package com.example.CozaStore.repository;

import com.example.CozaStore.entity.OrderDetailEntity;
import com.example.CozaStore.entity.keys.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailId> {
}
