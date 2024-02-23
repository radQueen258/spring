package com.example.spring.controllers;

import com.example.spring.dto.ArticleDto;
import com.example.spring.dto.ArticleForm;
import com.example.spring.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/users/{user-id}/article")
    @ResponseBody
    public ArticleDto addArticle(@PathVariable("user-id") Long id,
                                 @RequestBody ArticleForm articleForm) {
        return  articleService;
    }
}
