package com.example.CozaStore.service;

import com.example.CozaStore.entity.CategoryEntity;
import com.example.CozaStore.entity.ColorEntity;
import com.example.CozaStore.entity.ProductEntity;
import com.example.CozaStore.entity.SizeEntity;
import com.example.CozaStore.payload.request.ProductRequest;
import com.example.CozaStore.payload.response.ProductResponse;
import com.example.CozaStore.repository.ProductRepository;
import com.example.CozaStore.service.imp.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Value("${host.name}")
    private String host;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductByCategory(String host, int id) {
        List<ProductEntity> list = productRepository.findByCategoryId(id);
        List<ProductResponse> productResponseList = new ArrayList<>();

        for (ProductEntity data : list) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setImage("http://" + host +"/product/file/" + data.getImage());
            productResponse.setName(data.getName());
            productResponse.setPrice(data.getPrice());

            productResponseList.add(productResponse);
        }
        return productResponseList;
    }

    @Override
    public boolean addProduct(ProductRequest productRequest) {
        try {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productRequest.getName());
            productEntity.setPrice(productRequest.getPrice());
            productEntity.setDescription(productRequest.getDescription());
            productEntity.setQuantity(productRequest.getQuantity());

            SizeEntity sizeEntity = new SizeEntity();
            sizeEntity.setId(productRequest.getSizeId());

            ColorEntity colorEntity = new ColorEntity();
            colorEntity.setId(productRequest.getColorId());

            CategoryEntity categoryEntity = new CategoryEntity();
            categoryEntity.setId(productRequest.getCategoryId());

            productEntity.setColor(colorEntity);
            productEntity.setSize(sizeEntity);
            productEntity.setCategory(categoryEntity);

            productRepository.save(productEntity);
            return true;
        } catch (Exception e) {

            return false;
        }
    }
}
