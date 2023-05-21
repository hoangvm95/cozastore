package com.example.CozaStore.entity;

import com.example.CozaStore.entity.keys.CategoryTagId;

import javax.persistence.*;

@Entity(name="Category_tag")
public class CategoryTagEntity {
    // Đối với entity mà có 2 hay nhiều cột đóng vai trò là khoá chính thì khi nap phải thêm insertable
    // update là false
    @EmbeddedId
    private CategoryTagId ids;

    @ManyToOne
    @JoinColumn(name = "category_id",insertable = false,updatable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "tag_id",insertable = false,updatable = false)
    private TagEntity tag;

    public CategoryTagId getIds() {
        return ids;
    }

    public void setIds(CategoryTagId ids) {
        this.ids = ids;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public TagEntity getTag() {
        return tag;
    }

    public void setTag(TagEntity tag) {
        this.tag = tag;
    }
}
