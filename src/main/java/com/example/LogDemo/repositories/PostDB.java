package com.example.LogDemo.repositories;

import com.example.LogDemo.exeptions.DuplicatedPostException;
import com.example.LogDemo.exeptions.PostNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PostDB implements PostRepository{

    private Logger logger = LoggerFactory.getLogger(PostDB.class);

    private List<Post>posts = new ArrayList<>();


    @Override
    public List<Post> getAll() {
        logger.debug("Fetching all posts");
        return posts;
    }

    @Override
    public Post findById(Long id) {
        Optional<Post>optionalPost = posts.stream().filter(post -> post.getId() == id).findFirst();

        try{
            if(optionalPost.isPresent()){
                return optionalPost.get();
            }else{
                throw new PostNotFoundException("Post with "+id+" as id is not found");
            }
        }catch (Exception e){
            logger.error("Post search by id not found", e);
            throw e;
        }

    }

    @Override
    public Post findByAuthor(String author) {
        Optional<Post>optionalPost = posts.stream().filter(post -> post.getAuthor().equals(author)).findFirst();
        if(optionalPost.isPresent()){
            return optionalPost.get();
        }else{
            logger.error("Post search by author not found");
            throw new PostNotFoundException("Post with "+author+" as author is not found");
        }
    }

    @Override
    public String save(Post post) {
        logger.info("Adding a new post");
        try{
            saving(post);
            return "post successfully";
        }catch (RuntimeException e){
            logger.error("Post saving operation not successfully");
            throw e;
        }
    }

    private void saving(Post post){
        if(!posts.stream().anyMatch(p -> p.getTitle().equals(post.getTitle()))){
            post.setId((long) (posts.size()+1));
            posts.add(post);
        }else{
            throw new DuplicatedPostException("The post already exists");
        }
    }
}
