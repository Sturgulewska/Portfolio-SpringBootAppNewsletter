package com.course.newsletter.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "subscriber")

// wysylka na maile w swagerze podajesz id użytkownika i wysyła na maila wszystkie nie wysłane artykuły,
// w swagerze id uzytkownika jak podasz  to metoda zwróci wszysktkie nie przeczytane artykuly
// dodaj użytkownikow i fakowe emaile - baza danych 


//
// Godzinowa wysyłka na maile
public class SubscriberEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id")
    private List<SentArticleEntity> sentArticleList;
}

