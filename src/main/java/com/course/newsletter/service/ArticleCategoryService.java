package com.course.newsletter.service;

import com.course.newsletter.data.dto.EditArticleCategoryDto;
import com.course.newsletter.data.entity.ArticleCategoryEntity;
import com.course.newsletter.data.repository.ArticleCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleCategoryService {

    private final ArticleCategoryRepository repository;

    public ArticleCategoryService(ArticleCategoryRepository repository) {
        this.repository = repository;
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
}
