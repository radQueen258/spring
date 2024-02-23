package com.example.spring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    private String name;
    private String type;

    @Column(length = 1000)
    private String text;

    @JoinTable(name = "article_author")
    @ManyToOne
    private User author;

    @ManyToMany
    @JoinTable(name = "artcle_likes",
            joinColumns = @JoinColumn(name = "article_id", referencedColumnName = "article_id")
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")));
    private List<User> likes;

}
