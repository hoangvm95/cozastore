package com.example.CozaStore.service;

import com.example.CozaStore.entity.ColorEntity;
import com.example.CozaStore.payload.response.ColorResponse;
import com.example.CozaStore.repository.ColorRepository;
import com.example.CozaStore.service.imp.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService implements IColorService {
    @Autowired
    ColorRepository colorRepository;

    @Override
    public List<ColorResponse> getAllColor() {
       List<ColorEntity> list = colorRepository.findAll();
       List<ColorResponse> colorResponses = new ArrayList<>();

        for (ColorEntity item: list) {
            ColorResponse response = new ColorResponse();
            response.setId(item.getId());
            response.setName(item.getName());

            colorResponses.add(response);
        }
        return colorResponses;
    }
}
