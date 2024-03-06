package com.example.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.spring.dto.ArticleDto;
import com.example.spring.dto.ArticleForm;
import com.example.spring.models.Article;
import com.example.spring.models.User;
import com.example.spring.repositories.ArticlesRepository;
import com.example.spring.repositories.UsersRepository;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticlesRepository articlesRepository;

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

        articlesRepository.save(article);
        return ArticleDto.from(article);


    }

    @Override
    public List<ArticleDto> getByUser(Long id) {
        User user = usersRepository.getOne(id);
        List<Article> articleList = user.getCreatedArticles();
        return ArticleDto.articleList(articleList);
    }

    @Override
    public ArticleDto like(Long userId, Long articleId) {
        User user = usersRepository.getOne(userId);
        Article article = articlesRepository.getOne(articleId);

        if (articlesRepository.existsByArticleIdAndLikesContaining(articleId, user)) {
            article.getLikes().remove(user);
        }
        else {
            article.getLikes().add(user);
        }
        articlesRepository.save(article);
        return ArticleDto.from(article);
    }
}
