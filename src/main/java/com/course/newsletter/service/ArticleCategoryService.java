package com.course.newsletter.service;

import com.course.newsletter.data.dto.EditArticleCategoryDto;
import com.course.newsletter.data.entity.ArticleCategoryEntity;
import com.course.newsletter.data.entity.SubscriberEntity;
import com.course.newsletter.data.repository.ArticleCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleCategoryService {

    private final ArticleCategoryRepository repository;

    private final SubscriberArticleCategoryService sacService;

    public ArticleCategoryService(ArticleCategoryRepository repository, SubscriberArticleCategoryService sacService) {
        this.repository = repository;
        this.sacService = sacService;
    }

    public Optional<ArticleCategoryEntity> findByName(String name) {
        return repository.findByNameEquals(name);
    }

    public ArticleCategoryEntity save(ArticleCategoryEntity entity) {
        return repository.save(entity);
    }

    public ArticleCategoryEntity addNewCategory(String categoryName) {
        ArticleCategoryEntity entity = new ArticleCategoryEntity();
        entity.setName(categoryName);
        return save(entity);
    }

    public void editCategory(ArticleCategoryEntity entity, EditArticleCategoryDto dto) {
        entity.setName(dto.getNewCategoryName());
        save(entity);
    }

    public List<ArticleCategoryEntity> getSubscriberCategoryList(SubscriberEntity subscriber) {
        return sacService.getSubscriberCategoryList(subscriber);
    }
}
