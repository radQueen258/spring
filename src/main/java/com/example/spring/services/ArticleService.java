package com.example.spring.services;

import com.example.spring.dto.ArticleDto;
import com.example.spring.dto.ArticleForm;

import java.util.List;

public interface ArticleService {
    ArticleDto addArticle (Long userId, ArticleForm articleForm);

    List<ArticleDto> getByUser(Long id);

    ArticleDto like(Long userId, Long articleId);
}
