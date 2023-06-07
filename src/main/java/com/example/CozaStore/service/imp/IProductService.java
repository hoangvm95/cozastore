package com.example.CozaStore.service.imp;

import com.example.CozaStore.payload.request.ProductRequest;
import com.example.CozaStore.payload.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getProductByCategory(int id);

    boolean addProduct (ProductRequest productRequest);
}
