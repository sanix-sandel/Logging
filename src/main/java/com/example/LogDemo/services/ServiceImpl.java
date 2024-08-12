package com.example.LogDemo.services;

import com.example.LogDemo.repositories.Post;
import com.example.LogDemo.repositories.PostRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    private PostRepository postRepository;

    public ServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.getAll();
    }

    @Override
    public Post getById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post getByAuthor(String author) {
        return postRepository.findByAuthor(author);
    }

    @Override
    public String savePost(Post post) {
        return postRepository.save(post);
    }
}
