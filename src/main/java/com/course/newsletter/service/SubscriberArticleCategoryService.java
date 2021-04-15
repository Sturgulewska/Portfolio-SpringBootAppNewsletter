package com.course.newsletter.service;

import com.course.newsletter.data.entity.ArticleCategoryEntity;
import com.course.newsletter.data.entity.SubscriberEntity;
import com.course.newsletter.data.repository.SubscriberArticleCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberArticleCategoryService {
    private final SubscriberArticleCategoryRepository repository;

    public SubscriberArticleCategoryService(SubscriberArticleCategoryRepository repository) {
        this.repository = repository;
    }

    public List<ArticleCategoryEntity> getSubscriberCategoryList(SubscriberEntity subscriber) {
        return repository.getSubscriberCategoryList(subscriber);
    }
}
