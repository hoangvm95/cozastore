package com.example.CozaStore.entity.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class CategoryTagId implements Serializable {
    @Column(name="category_id")
    private int categoryId;
    @Column(name="tag_id")
    private int tagId;

    public CategoryTagId() {
    }
    //JPA sẽ thông qua phương thức khởi tạo để insert dữ liệu đúng cột khi thực hiện câu insert,update
    public CategoryTagId(int categoryId, int tagId) {
        this.categoryId = categoryId;
        this.tagId = tagId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
