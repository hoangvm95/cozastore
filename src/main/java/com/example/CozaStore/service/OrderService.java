package com.example.CozaStore.service;

import com.example.CozaStore.entity.CountryEntity;
import com.example.CozaStore.entity.OrderDetailEntity;
import com.example.CozaStore.entity.OrdersEntity;
import com.example.CozaStore.entity.keys.OrderDetailId;
import com.example.CozaStore.payload.request.OrderProductRequest;
import com.example.CozaStore.payload.request.OrderRequest;
import com.example.CozaStore.repository.OrderDetailRepository;
import com.example.CozaStore.repository.OrderRepository;
import com.example.CozaStore.service.imp.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderService implements IOrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;



    @Override
    public boolean addOrder(OrderRequest orderRequest) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(orderRequest.getCountryId());

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setCountry(countryEntity);
// Khi save thành công thì thuộc tính id của OrderEntity sẽ có giá trị
        orderRepository.save(ordersEntity);
// Thêm tiếp dữ liệu cho bảng order detail
        for (OrderProductRequest data: orderRequest.getListProduct()) {

// Gán giá trị cho key trong OrderDetailEntity
            OrderDetailId ids = new OrderDetailId();
            ids.setOrderId(ordersEntity.getId());
            ids.setProductId(data.getId());

            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setIds(ids);
            orderDetailEntity.setPrice(String.valueOf(data.getPrice()));
            orderDetailEntity.setQuantity(String.valueOf(data.getQuantity()));

            orderDetailRepository.save(orderDetailEntity);
        }
        return false;
    }
}
