package com.burakenesdemir.cms.controller;

import com.burakenesdemir.cms.data.entity.Post;
import com.burakenesdemir.cms.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post) {
        postService.create(post);

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Post> update(@RequestBody Post post) {
        postService.update(post);

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Post> delete(@PathVariable("id") Long id) {
        Post post = postService.delete(id);

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok().body(postService.getAll());

    }
}
