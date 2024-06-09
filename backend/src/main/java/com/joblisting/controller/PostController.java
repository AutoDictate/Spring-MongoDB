package com.joblisting.controller;

import com.joblisting.entity.Post;
import com.joblisting.repository.PostRepo;
import com.joblisting.repository.SearchRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostRepo repo;

    @Autowired
    SearchRepository searchRepository;

    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("posts/{text}")
    public List<Post> search(@PathVariable String text){
        return searchRepository.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        return repo.save(post);
    }

}
