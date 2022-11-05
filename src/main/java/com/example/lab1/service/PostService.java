package com.example.lab1.service;

import com.example.lab1.entity.Post;
import com.example.lab1.entity.User;
import com.example.lab1.repo.PostRepo;
import com.example.lab1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepository;

    @Autowired
    private UserRepo userRepository;

    public Post findById(long id){
        return postRepository.findById(id).get();
    }

    public String delete(long u_id,long p_id){
        User user = userRepository.findById(u_id).get();
        List<Post> posts = user.getPosts().stream().filter(p->p.getId()!=p_id).collect(Collectors.toList());
        user.setPosts(posts);
        userRepository.save(user);
        return "deleted post id:"+p_id;
    }

    public List<Post> filterPostByTitle(String str){
        return postRepository.filterPostByTitle(str);
    }


}
