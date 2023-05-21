package com.example.CozaStore.service;

import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.util.ClassUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

// Exception: Quăng lỗi và kết thúc code
// Compare : so sánh
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByUsername(username);
        if(user == null){
// Không tìm thấy user trong hệ thống
            throw new UsernameNotFoundException("User không tồn tại");
        }else {
            User user1 = new User(user.getUsername(),user.getPassword(),new ArrayList<>());
            return user1;
        }
    }
}
