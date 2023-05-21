package com.example.CozaStore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="tag")
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "tag")
    private Set<CategoryTagEntity> listCategoryTag;

    @OneToMany(mappedBy = "tag")
    private Set<TagBlogEntity> listtagBlog;

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

    public Set<CategoryTagEntity> getListCategoryTag() {
        return listCategoryTag;
    }

    public void setListCategoryTag(Set<CategoryTagEntity> listCategoryTag) {
        this.listCategoryTag = listCategoryTag;
    }

    public Set<TagBlogEntity> getListtagBlog() {
        return listtagBlog;
    }

    public void setListtagBlog(Set<TagBlogEntity> listtagBlog) {
        this.listtagBlog = listtagBlog;
    }
}
