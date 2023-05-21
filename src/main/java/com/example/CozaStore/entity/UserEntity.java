package com.example.CozaStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<OrdersEntity> listOrder;

    @OneToMany(mappedBy = "user")
    private Set<BlogEntity> listBlog;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OrdersEntity> getListOrder() {
        return listOrder;
    }

    public void setListOrder(Set<OrdersEntity> listOrder) {
        this.listOrder = listOrder;
    }

    public Set<BlogEntity> getListBlog() {
        return listBlog;
    }

    public void setListBlog(Set<BlogEntity> listBlog) {
        this.listBlog = listBlog;
    }
}
