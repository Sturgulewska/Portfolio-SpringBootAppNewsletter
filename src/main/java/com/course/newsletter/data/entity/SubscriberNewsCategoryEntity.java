package com.course.newsletter.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscriber_news_category")
public class SubscriberNewsCategoryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id")
    private SubscriberEntity subscriberEntity;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ArticleCategoryEntity categoryEntity;
}
