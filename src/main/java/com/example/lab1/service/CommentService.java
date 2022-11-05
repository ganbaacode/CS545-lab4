package com.example.lab1.service;

import com.example.lab1.entity.Comment;
import com.example.lab1.entity.Post;
import com.example.lab1.entity.User;
import com.example.lab1.repo.CommentRepo;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    public String save(long u_id,long p_id,Comment comment){
        User myUser = userRepo.findById(u_id).get();
        List<Post> myPosts = myUser.getPosts();
        Post myPost = myPosts.stream().filter(p->p.getId()==p_id).findFirst().get();
        myPost.getComments().add(comment);
        postRepo.save(myPost);
        return "Successfully added comment on post id: "+p_id;
    }

    public List<Comment> findCommentById(long u_id,long p_id){
        User myUser = userRepo.findById(u_id).get();
        List<Post> myPosts = myUser.getPosts();
        Post myPost = myPosts.stream().filter(p->p.getId()==p_id).findFirst().get();
        List<Comment> myComments = myPost.getComments();
        return myComments;
    }

    public String delete(long u_id,long p_id,long c_id){
        User myUser = userRepo.findById(u_id).get();
        List<Post> myPosts = myUser.getPosts();
        Post myPost = myPosts.stream().filter(p->p.getId()==p_id).findFirst().get();
        List<Comment> coms = myPost.getComments().stream().filter(c->c.getId()!=c_id).collect(Collectors.toList());
        myPost.setComments(coms);
        postRepo.save(myPost);
        return "successfully deleted comment id: "+c_id;
    }



}
