package com.course.newsletter.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table
@Entity(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ArticleCategoryEntity category;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "date_add")
    private LocalDateTime dateAdd;
}
