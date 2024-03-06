package com.example.spring.dto;

import com.example.spring.models.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String text;
    private String authorName;
    private Integer likeCount;


    public  static ArticleDto from(Article article) {
        return ArticleDto.builder()
                .id(article.getArticleId())
                .text(article.getText())
                .authorName(article.getAuthor().getEmail())
                .likeCount(article.getLikes().size())
                .build();
    }

    public static List<ArticleDto> articleList(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
