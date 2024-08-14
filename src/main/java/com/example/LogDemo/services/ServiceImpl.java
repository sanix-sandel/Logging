package com.example.LogDemo.services;

import com.example.LogDemo.repositories.Post;
import com.example.LogDemo.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{

    private Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

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
        logger.debug("Get post by id "+id);
        return postRepository.findById(id);
    }

    @Override
    public Post getByAuthor(String author) {
        logger.debug("Get post by author "+author);
        return postRepository.findByAuthor(author);
    }

    @Override
    public String savePost(Post post) {
        return postRepository.save(post);
    }
}
