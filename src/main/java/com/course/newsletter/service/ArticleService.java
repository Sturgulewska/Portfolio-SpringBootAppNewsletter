package com.course.newsletter.service;

import com.course.newsletter.data.consts.DateTimeFormat;
import com.course.newsletter.data.dto.ArticleDto;
import com.course.newsletter.data.dto.ArticleListDto;
import com.course.newsletter.data.entity.ArticleCategoryEntity;
import com.course.newsletter.data.entity.ArticleEntity;
import com.course.newsletter.data.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public ArticleEntity save(ArticleEntity entity) {
        return repository.save(entity);
    }

    public ArticleEntity addArticle(ArticleDto articleDto, ArticleCategoryEntity category) {
        ArticleEntity entity = new ArticleEntity();
        entity.setName(articleDto.getArticleName());
        entity.setContent(articleDto.getArticleContent());
        entity.setDateAdd(LocalDateTime.now());
        entity.setCategory(category);
        return save(entity);
    }

    public ArticleListDto getArticleList() {
        ArticleListDto dto = new ArticleListDto();
        List<ArticleDto> articleDtoList = dto.getArticleList();
        List<ArticleEntity> articleList = repository.findAll();

        articleList.forEach(a -> {
            ArticleDto articleDto = new ArticleDto(a.getCategory().getName(), a.getName(), a.getContent(), a.getDateAdd().format(DateTimeFormat.FULL_DATETIME_FORMAT));
            articleDtoList.add(articleDto);
        });

        return dto;
    }

    public List<ArticleEntity> findByCategory(ArticleCategoryEntity category) {
        return repository.findByCategory(category);
    }
}
