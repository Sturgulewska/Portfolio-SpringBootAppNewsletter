package com.course.newsletter.data.entity;;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "d_news_category")
public class ArticleCategoryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
