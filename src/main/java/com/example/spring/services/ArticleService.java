package com.example.spring.services;

import com.example.spring.dto.ArticleDto;
import com.example.spring.dto.ArticleForm;

public interface ArticleService {
    public ArticleDto addArticle (Long userId, ArticleForm articleForm);
}
