package com.example.CozaStore.entity.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class OrderDetailId implements Serializable {
    @Column(name="product_id")
    private int productId;
    @Column(name="order_id")
    private int orderId;

    public OrderDetailId() {
    }

    public OrderDetailId(int productId, int orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
