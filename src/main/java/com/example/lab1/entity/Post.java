package com.example.lab1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

}
