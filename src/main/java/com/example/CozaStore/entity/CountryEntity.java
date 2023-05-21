package com.example.CozaStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price_ship")
    private String priceShip;

    @OneToMany(mappedBy = "country")
    private Set<OrdersEntity> listOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceShip() {
        return priceShip;
    }

    public void setPriceShip(String priceShip) {
        this.priceShip = priceShip;
    }

    public Set<OrdersEntity> getListOrder() {
        return listOrder;
    }

    public void setListOrder(Set<OrdersEntity> listOrder) {
        this.listOrder = listOrder;
    }
}
