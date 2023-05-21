package com.example.CozaStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<ProductEntity> listproduct;

    @OneToMany(mappedBy = "category")
    private Set<CategoryTagEntity> listCategoryTag;

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

    public Set<CategoryTagEntity> getListCategoryTag() {
        return listCategoryTag;
    }

    public void setListCategoryTag(Set<CategoryTagEntity> listCategoryTag) {
        this.listCategoryTag = listCategoryTag;
    }

}
