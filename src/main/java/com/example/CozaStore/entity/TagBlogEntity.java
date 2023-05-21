package com.example.CozaStore.entity;

import com.example.CozaStore.entity.keys.TagBlogId;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="tag_blog")
public class TagBlogEntity {
    @EmbeddedId
    private TagBlogId tagBlog;

    @ManyToOne
    @JoinColumn(name = "tag_id",insertable = false,updatable = false)
    private TagEntity tag;

    @ManyToOne
    @JoinColumn(name = "blog_id", insertable = false,updatable = false)
    private BlogEntity blog;

    public TagBlogId getTagBlog() {
        return tagBlog;
    }

    public void setTagBlog(TagBlogId tagBlog) {
        this.tagBlog = tagBlog;
    }

    public TagEntity getTag() {
        return tag;
    }

    public void setTag(TagEntity tag) {
        this.tag = tag;
    }

    public BlogEntity getBlog() {
        return blog;
    }

    public void setBlog(BlogEntity blog) {
        this.blog = blog;
    }
}
