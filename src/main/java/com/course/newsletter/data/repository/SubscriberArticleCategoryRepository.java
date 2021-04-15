package com.course.newsletter.data.repository;

import com.course.newsletter.data.entity.ArticleCategoryEntity;
import com.course.newsletter.data.entity.SubscriberArticleCategoryEntity;
import com.course.newsletter.data.entity.SubscriberEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriberArticleCategoryRepository extends CrudRepository<SubscriberArticleCategoryEntity, Long> {

    @Query(value = "SELECT a.categoryEntity FROM SubscriberArticleCategoryEntity a WHERE a.subscriberEntity = ?1")
    List<ArticleCategoryEntity> getSubscriberCategoryList(SubscriberEntity subscriberEntity);
}
