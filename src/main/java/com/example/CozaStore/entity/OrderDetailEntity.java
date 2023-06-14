package com.example.CozaStore.entity;

import com.example.CozaStore.entity.keys.OrderDetailId;

import javax.persistence.*;

@Entity(name="order_detail")
public class OrderDetailEntity {
    @Column(name="price")
    private String price;
    @Column(name="quantity")
    private String quantity;

    @EmbeddedId
    private OrderDetailId ids;

    @ManyToOne
    @JoinColumn(name = "product_id",insertable = false,updatable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name="order_id",insertable = false,updatable = false)
    private OrdersEntity orders;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public OrderDetailId getIds() {
        return ids;
    }

    public void setIds(OrderDetailId ids) {
        this.ids = ids;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }
}
