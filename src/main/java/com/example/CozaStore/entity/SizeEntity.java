package com.example.CozaStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="size")
public class SizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "size")
    private Set<ProductEntity> listproduct;

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

    public Set<ProductEntity> getListproduct() {
        return listproduct;
    }

    public void setListproduct(Set<ProductEntity> listproduct) {
        this.listproduct = listproduct;
    }
}
