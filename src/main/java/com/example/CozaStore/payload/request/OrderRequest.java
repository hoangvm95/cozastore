package com.example.CozaStore.payload.request;

import java.util.List;

public class OrderRequest {
    private int countryId;
    List<OrderProductRequest> listProduct;

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public List<OrderProductRequest> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<OrderProductRequest> listProduct) {
        this.listProduct = listProduct;
    }
}
