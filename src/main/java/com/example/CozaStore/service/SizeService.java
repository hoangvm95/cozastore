package com.example.CozaStore.service;

import com.example.CozaStore.entity.SizeEntity;
import com.example.CozaStore.payload.response.ProductResponse;
import com.example.CozaStore.payload.response.SizeResponse;
import com.example.CozaStore.repository.SizeRepository;
import com.example.CozaStore.service.imp.ISizeService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class SizeService implements ISizeService {
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    RedisTemplate redisTemplate;
    private Gson gson = new Gson();

    @Override
    public List<SizeResponse> getAllSize() {
        List<SizeResponse> responses = new ArrayList<>();

        if (redisTemplate.hasKey("ListSize")){
            System.out.println("Có Redis size");
            String dataSize= (String) redisTemplate.opsForValue().get("ListSize");
            Type listType = new TypeToken<ArrayList<SizeResponse>>(){}.getType();
            responses = new Gson().fromJson(dataSize, listType);
        }else{
            System.out.println("Không có Redis size");
            List<SizeEntity> list = sizeRepository.findAll();
            for (SizeEntity item : list) {
                SizeResponse sizeResponse = new SizeResponse();
                sizeResponse.setId(item.getId());
                sizeResponse.setName(item.getName());

                responses.add(sizeResponse);
            }
            String listSize = gson.toJson(responses);
            redisTemplate.opsForValue().set("ListSize",listSize);
        }

        return responses;
    }
}
