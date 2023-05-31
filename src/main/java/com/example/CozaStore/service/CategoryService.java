package com.example.CozaStore.service;

import com.example.CozaStore.entity.CategoryEntity;
import com.example.CozaStore.payload.response.CategoryResponse;
import com.example.CozaStore.repository.CategoryRepository;
import com.example.CozaStore.service.imp.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryResponse> responseList = new ArrayList<>();
        for (CategoryEntity item: list) {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(item.getId());
            categoryResponse.setName(item.getName());
            responseList.add(categoryResponse);
        }
        return responseList;
    }
}
