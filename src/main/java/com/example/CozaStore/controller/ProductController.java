package com.example.CozaStore.controller;

import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductByCategoryId(@PathVariable int id){
        BaseResponse response = new BaseResponse();
        response.setData(iProductService.getProductByCategory(3));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
