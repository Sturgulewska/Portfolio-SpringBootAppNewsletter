package com.course.newsletter.controller;

import com.course.newsletter.data.entity.ArticleCategoryEntity;
import com.course.newsletter.data.entity.ArticleEntity;
import com.course.newsletter.data.entity.SentArticleEntity;
import com.course.newsletter.data.entity.SubscriberEntity;
import com.course.newsletter.service.ArticleCategoryService;
import com.course.newsletter.service.ArticleService;
import com.course.newsletter.service.EmailService;
import com.course.newsletter.service.SubscriberService;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping(name = "email")
@RestController
@CrossOrigin
public class EmailController {

    private final EmailService emailService;
    private final SubscriberService subscriberService;
    private final ArticleService articleService;
    private final ArticleCategoryService articleCategoryService;

    public EmailController(EmailService emailService,
                           SubscriberService subscriberService,
                           ArticleService articleService, ArticleCategoryService articleCategoryService) {
        this.emailService = emailService;
        this.subscriberService = subscriberService;
        this.articleService = articleService;
        this.articleCategoryService = articleCategoryService;
    }

    @RequestMapping(
            value = "/sendEmail",
            method = RequestMethod.GET
    )
    public String sendEmail() {
        try {
            emailService.sendEmail("jakkacz@yahoo.com", "Próba1", "Tresc");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "OK";
    }

    @RequestMapping(
            value = "/sendArticle/{subscriberId}",
            method = RequestMethod.GET
    )
    public String sendArticle(@PathVariable("subscriberId") Long subscriberId) {
        Optional<SubscriberEntity> optionalEntity = subscriberService.findById(subscriberId);
        if (!optionalEntity.isPresent()) {
            return "Podany subskrybent: " + subscriberId + " nie istnieje!";
        }

        SubscriberEntity subscriber = optionalEntity.get();
        List<ArticleEntity> articleListToSend = new ArrayList<>();
        List<ArticleCategoryEntity> categoryList = articleCategoryService.getSubscriberCategoryList(subscriber);
        List<ArticleEntity> sentArticleList = subscriber
                .getSentArticleList()
                .stream()
                .map(SentArticleEntity::getNewsArticleEntity)
                .collect(Collectors.toList());

        categoryList.forEach(c -> {
            List<ArticleEntity> articleList = articleService.findByCategory(c);
            List<ArticleEntity> notSentArticles = articleList.stream()
                    .filter(a -> {
                        if (!sentArticleList.contains(a)) {
                            return true;
                        }

                        return false;
                    })
                    .collect(Collectors.toList());

            articleListToSend.addAll(notSentArticles);
        });

        if (articleListToSend.isEmpty()) {
            return "Brak artykułów do wysłania!";
        }

        try {
            for (ArticleEntity articleToSend: articleListToSend) {
                emailService.sendEmail(subscriber.getEmail(), articleToSend.getName(), articleToSend.getContent());
            }

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "OK";
    }


}
