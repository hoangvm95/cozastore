package com.example.CozaStore.service.imp;

import com.example.CozaStore.payload.request.OrderRequest;

import javax.servlet.http.HttpServletRequest;

public interface IOrderService {
    boolean addOrder (OrderRequest orderRequest, HttpServletRequest request);
}
