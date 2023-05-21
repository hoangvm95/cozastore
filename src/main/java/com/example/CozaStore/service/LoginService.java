package com.example.CozaStore.service;

import com.example.CozaStore.dto.UserDto;
import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.payload.request.SignUpRequest;
import com.example.CozaStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public boolean checklogin (String username, String password) {
        List<UserEntity> list = userRepository.findByUsernameAndPassword(username, password);
        return list.size() > 0;

    }

    public boolean insertUser(SignUpRequest signup) {
        try {
            UserEntity user = new UserEntity();

            user.setEmail(signup.getEmail());
            user.setUsername(signup.getUsername());
            user.setPassword(signup.getPassword());

            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("Error insert User" + e.getMessage());
            return false;
        }
    }
}
