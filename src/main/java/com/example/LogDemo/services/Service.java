package com.example.LogDemo.services;

import com.example.LogDemo.repositories.Post;

import java.util.List;

public interface Service {

    public List<Post>findAll();

    public Post getById(Long id);

    public Post getByAuthor(String author);

    public String savePost(Post post);

}
