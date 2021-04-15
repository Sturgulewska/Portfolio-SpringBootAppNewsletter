package com.course.newsletter.data.repository;

import com.course.newsletter.data.entity.ArticleCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleCategoryRepository extends CrudRepository<ArticleCategoryEntity, Long> {
    Optional<ArticleCategoryEntity> findByNameEquals(String name);
}
