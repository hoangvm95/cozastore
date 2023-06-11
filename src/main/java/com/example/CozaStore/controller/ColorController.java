package com.example.CozaStore.controller;

import com.example.CozaStore.payload.response.BaseResponse;
import com.example.CozaStore.service.imp.IColorService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/color")
public class ColorController {
    private Logger logger = LoggerFactory.getLogger(ColorController.class);
    Gson gson = new Gson();

    @Autowired
    IColorService iColorService;

    @GetMapping("")
    public ResponseEntity<?> getAllColor(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iColorService.getAllColor());

        String data = gson.toJson(baseResponse);
        logger.info(data);
        return new ResponseEntity<>(iColorService, HttpStatus.OK);
    }
}
