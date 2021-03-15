package com.course.newsletter.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "subscriber")
public class SubscriberEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "e-mail")
    private String email;

    @OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id")
    private List<SentArticleEntity> sentArticleList;
}

