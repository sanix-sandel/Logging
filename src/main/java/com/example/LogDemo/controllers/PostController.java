package com.example.LogDemo.controllers;


import com.example.LogDemo.repositories.Post;
import com.example.LogDemo.repositories.PostDB;
import com.example.LogDemo.services.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class PostController {

    private Service service;

    public PostController(Service service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<Post>>getPosts(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> save(Post post){
        return ResponseEntity.ok(service.savePost(post));
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getById(Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<Post> getByAuthor(String author){
        return ResponseEntity.ok(service.getByAuthor(author));
    }

}
