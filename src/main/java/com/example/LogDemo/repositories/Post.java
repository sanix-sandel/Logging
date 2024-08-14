package com.example.LogDemo.repositories;

import jdk.jfr.DataAmount;

import java.util.Date;


public class Post {

    private Long id;
    private String title;
    private Date datePosted;
    private String author;

    public Post(String title, Date datePosted, String author) {
        this.title = title;
        this.datePosted = new Date();
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", datePosted=" + datePosted +
                ", author='" + author + '\'' +
                '}';
    }
}
