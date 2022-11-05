package com.example.lab1.controller;

import com.example.lab1.entity.Comment;
import com.example.lab1.service.CommentService;
import com.example.lab1.service.PostService;
import com.example.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class CommentController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/{u_id}/posts/{p_id}")
    public String addComment(@PathVariable Long u_id, @PathVariable Long p_id, @RequestBody Comment com){
        return commentService.save(u_id,p_id,com);
    }

    @GetMapping("/{u_id}/posts/{p_id}")
    public List<Comment> findAllComment(@PathVariable Long u_id,@PathVariable Long p_id){
        return commentService.findCommentById(u_id,p_id);
    }

    @DeleteMapping("/{u_id}/posts/{p_id}/comments/{c_id}")
    public String delete(@PathVariable long u_id,@PathVariable long p_id,@PathVariable long c_id){
        return commentService.delete(u_id,p_id,c_id);
    }
}
