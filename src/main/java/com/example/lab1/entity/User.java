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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "id_user")

    private List<Post> posts;
}
