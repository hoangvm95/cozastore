package com.example.CozaStore.controller;

import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@CrossOrigin

public class HomeController {
    @Autowired
    private HomeService homeService;

    // Cần xác định được kiểu JSON trả ra cho bên FE và để tiện cho BE xử lý chức năng sau này

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategory(){
        BaseResponse response = new BaseResponse();
        response.setData(homeService.getAllCategory());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
