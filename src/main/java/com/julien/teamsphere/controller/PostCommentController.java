package com.julien.teamsphere.controller;

import com.julien.teamsphere.DTO.PostCommentDTO;
import com.julien.teamsphere.services.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/comment")
public class PostCommentController {

    private final PostCommentService postCommentService;

    @Autowired
    public PostCommentController(PostCommentService postCommentService) {
        this.postCommentService = postCommentService;
    }

    @GetMapping
    public List<PostCommentDTO> findAllComment() {
        return postCommentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostCommentDTO> findCommentById(@PathVariable int id) {
        PostCommentDTO commentDTO = postCommentService.findById(id);
        if (null != commentDTO) {
            return ResponseEntity.ok(commentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> saveComment(@RequestBody PostCommentDTO commentDTO) {
        boolean isSaved = postCommentService.save(commentDTO);

        if (isSaved) {
            return ResponseEntity.ok("{\"message\": \"Comment published successfully\"}");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCommentById(@PathVariable int id, @RequestBody PostCommentDTO commentDTO) {
        boolean isUpdated = postCommentService.updateById(id, commentDTO);

        if (isUpdated) {
            return ResponseEntity.ok("{\"message\": \"Comment updated successfully\"}");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        boolean isDeleted = postCommentService.deleteById(id);

        if (isDeleted) {
            return ResponseEntity.ok("{\"message\": \"Comment deleted successfully\"}");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
