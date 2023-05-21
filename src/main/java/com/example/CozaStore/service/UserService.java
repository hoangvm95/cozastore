package com.example.CozaStore.service;

import com.example.CozaStore.dto.UserDto;
import com.example.CozaStore.entity.BlogEntity;
import com.example.CozaStore.entity.OrdersEntity;
import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

}

