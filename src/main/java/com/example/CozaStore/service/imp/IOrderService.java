package com.example.CozaStore.service.imp;

import com.example.CozaStore.payload.request.OrderRequest;

public interface IOrderService {
    boolean addOrder (OrderRequest orderRequest);
}
