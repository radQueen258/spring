package com.example.spring.repositories;

import com.example.spring.models.Article;
import com.example.spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
    boolean existsByArticleIdAndLikesContaining (Long articleId, User user);
}
