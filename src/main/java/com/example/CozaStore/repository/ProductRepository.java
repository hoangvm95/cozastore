package com.example.CozaStore.repository;

import com.example.CozaStore.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByCategoryId(int id);
}
