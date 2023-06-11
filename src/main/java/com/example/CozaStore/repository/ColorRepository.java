package com.example.CozaStore.repository;

import com.example.CozaStore.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity,Integer> {
}
