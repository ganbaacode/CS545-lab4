package com.example.lab1.repo;

import com.example.lab1.entity.Post;
import com.example.lab1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
    @Query("select p from Post p where p.title = :t")
    public List<Post> filterPostByTitle(String t);


}
