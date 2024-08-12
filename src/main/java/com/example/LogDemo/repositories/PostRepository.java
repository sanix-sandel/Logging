package com.example.LogDemo.repositories;

import java.util.List;

public interface PostRepository {

    List<Post> getAll();

    Post findById(Long id);

    Post findByAuthor(String author);

    String save(Post post);
}
