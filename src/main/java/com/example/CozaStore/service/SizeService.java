package com.example.CozaStore.service;

import com.example.CozaStore.entity.SizeEntity;
import com.example.CozaStore.payload.response.SizeResponse;
import com.example.CozaStore.repository.SizeRepository;
import com.example.CozaStore.service.imp.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeService implements ISizeService {
    @Autowired
    SizeRepository sizeRepository;

    @Override
    public List<SizeResponse> getAllSize() {
        List<SizeEntity> list = sizeRepository.findAll();
        List<SizeResponse> responses = new ArrayList<>();
        for (SizeEntity item : list) {
            SizeResponse sizeResponse = new SizeResponse();
            sizeResponse.setId(item.getId());
            sizeResponse.setName(item.getName());

            responses.add(sizeResponse);
        }
        return responses;
    }
}
