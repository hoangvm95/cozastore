package com.example.CozaStore.service;

import com.example.CozaStore.entity.ProductEntity;
import com.example.CozaStore.payload.response.ProductResponse;
import com.example.CozaStore.repository.ProductRepository;
import com.example.CozaStore.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductByCategory(int id) {
        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> productResponseList = new ArrayList<>();

        for (ProductEntity data : list) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setImage(data.getImage());
            productResponse.setName(data.getName());
            productResponse.setPrice(data.getPrice());

            productResponseList.add(productResponse);
        }
        return productResponseList;
    }
}
