package com.example.CozaStore.entity.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TagBlogId implements Serializable {
    @Column(name="tag_id")
    private int tagId;
    @Column(name="blog_id")
    private int blogId;

    public TagBlogId() {
    }

    public TagBlogId(int tagId, int blogId) {
        this.tagId = tagId;
        this.blogId = blogId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
}
