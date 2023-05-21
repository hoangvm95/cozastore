package com.example.CozaStore.repository;

import com.example.CozaStore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

   public List<UserEntity> findByUsernameAndPassword (String username, String password);

   UserEntity findByUsername (String username);

}
