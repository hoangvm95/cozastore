package com.example.CozaStore.service.imp;

import com.example.CozaStore.payload.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> getAllCategory();
}
