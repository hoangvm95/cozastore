package com.example.CozaStore.service;

import com.example.CozaStore.entity.CountryEntity;
import com.example.CozaStore.entity.OrderDetailEntity;
import com.example.CozaStore.entity.OrdersEntity;
import com.example.CozaStore.entity.UserEntity;
import com.example.CozaStore.entity.keys.OrderDetailId;
import com.example.CozaStore.exception.UserNotFoundException;
import com.example.CozaStore.payload.request.OrderProductRequest;
import com.example.CozaStore.payload.request.OrderRequest;
import com.example.CozaStore.repository.OrderDetailRepository;
import com.example.CozaStore.repository.OrderRepository;
import com.example.CozaStore.repository.UserRepository;
import com.example.CozaStore.service.imp.IOrderService;
import com.example.CozaStore.utils.JWTHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
@Transactional
public class OrderService implements IOrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private JWTHelperUtils jwtHelperUtils;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean addOrder(OrderRequest orderRequest, HttpServletRequest request) {
// Bước 1: Lấy token
// Bước 2: Giải mã lại token
// Bước 3: username or id
        // Lấy token từ header
        String header = request.getHeader("Authorization");
        if (header == null || header.isEmpty()){
            throw new UserNotFoundException(500,"Bạn không có quyền sử dụng tính năng này");
        }

        String token = header.substring(7);
        String dataToken = jwtHelperUtils.validToken(token);
        UserEntity userEntity = userRepository.findByUsername(dataToken);
        if (userEntity == null){
            throw new UserNotFoundException(500,"Bạn không có quyền sử dụng tính năng này");
        }
        // query database và lấy ra userId


        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(orderRequest.getCountryId());

        OrdersEntity ordersEntity = new OrdersEntity();
        ordersEntity.setCountry(countryEntity);
        ordersEntity.setUser(userEntity);
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
