package com.example.CozaStore.service;

import com.example.CozaStore.entity.CategoryEntity;
import com.example.CozaStore.entity.SizeEntity;
import com.example.CozaStore.payload.response.CategoryResponse;
import com.example.CozaStore.payload.response.SizeResponse;
import com.example.CozaStore.repository.CategoryRepository;
import com.example.CozaStore.service.imp.ICategoryService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RedisTemplate redisTemplate;
    private Gson gson = new Gson();

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<CategoryResponse> responseList = new ArrayList<>();
        if (redisTemplate.hasKey("ListCategory")){
            System.out.println("Có Redis Category");
            String dataSize= (String) redisTemplate.opsForValue().get("ListSize");
            Type listType = new TypeToken<ArrayList<SizeResponse>>(){}.getType();
            responseList = new Gson().fromJson(dataSize, listType);
        }else{
            System.out.println("Không có Redis category");
            List<CategoryEntity> list = categoryRepository.findAll();
        for (CategoryEntity item: list) {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(item.getId());
            categoryResponse.setName(item.getName());
            responseList.add(categoryResponse);
            }
            String listCategory = gson.toJson(responseList);
            redisTemplate.opsForValue().set("ListSize",listCategory);
        }
        return responseList;
    }
}
