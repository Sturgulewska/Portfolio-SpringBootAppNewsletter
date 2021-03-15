package com.course.newsletter.data.repository;

import com.course.newsletter.data.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleEntity, Long> {
    List<ArticleEntity> findAll();
}
