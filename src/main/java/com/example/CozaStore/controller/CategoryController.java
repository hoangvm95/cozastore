package com.example.CozaStore.controller;

import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity getAllCategory(){
        BaseResponse response = new BaseResponse();
        response.setData(iCategoryService.getAllCategory());
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
