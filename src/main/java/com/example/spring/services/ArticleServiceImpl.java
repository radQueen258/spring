package com.example.spring.services;

import com.example.spring.dto.ArticleDto;
import com.example.spring.dto.ArticleForm;
import com.example.spring.models.Article;
import com.example.spring.models.User;
import com.example.spring.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public ArticleDto addArticle(Long userId, ArticleForm articleForm) {
        User user = usersRepository.getOne(userId);

        Article article = Article.builder()
                .author(user)
                .type(articleForm.getType())
                .text(articleForm.getText())
                .name(articleForm.getName())
                .build();
    }
}
