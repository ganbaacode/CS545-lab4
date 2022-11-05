package com.example.lab1.controller;

import com.example.lab1.entity.Post;
import com.example.lab1.entity.User;
import com.example.lab1.service.PostService;
import com.example.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
public class PostController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping("/{id}/posts")
    public List<Post> getPostByUserId(@PathVariable long id){
        User myUser =  userService.getUserById(id);
        return myUser.getPosts();
    }

    @PostMapping("/{id}/posts")
    public String addPostById(@PathVariable long id,@RequestBody Post post){
        User myUser =  userService.getUserById(id);
        myUser.getPosts().add(post);
        userService.addUser(myUser);
        return "Successfully added post to user: "+id;
    }
    @DeleteMapping("/{u_id}/posts/{p_id}")
    public String delete(@PathVariable long u_id,@PathVariable long p_id){
        return postService.delete(u_id,p_id);
    }

    @GetMapping("/posts/filter/{str}")
    public List<Post> filterPost(@PathVariable String str){
        return postService.filterPostByTitle(str);
    }

}
