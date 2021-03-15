package com.course.newsletter.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sent_article")
public class SentArticleEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id")
    private SubscriberEntity newsSubsEntity;

    @OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private ArticleEntity newsArticleEntity;
}
