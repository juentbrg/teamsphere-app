package com.julien.teamsphere.controller;

import com.julien.teamsphere.DTO.PostDTO;
import com.julien.teamsphere.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/post")
public class PostController {

    private final PostService postService;

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> findAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findPostById(@PathVariable int id) {
        PostDTO post = postService.findById(id);
        if (null != post) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDTO post) {
        boolean isSaved = postService.save(post);
        if (isSaved) {
            return ResponseEntity.ok("{\"message\": \"Post published successfully\"}");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable int id) {
        boolean isDeleted = postService.deleteById(id);
        if (isDeleted) {
            return ResponseEntity.ok("{\"message\": \"Post published successfully\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePostById(@PathVariable int id, @RequestBody PostDTO postDTO) {
        boolean isUpdated = postService.updateById(id, postDTO);
        if (isUpdated) {
            return ResponseEntity.ok("{\"message\": \"Post updated successfully\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
