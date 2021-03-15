package com.course.newsletter.controller;

import com.course.newsletter.data.dto.ArticleDto;
import com.course.newsletter.data.dto.ArticleListDto;
import com.course.newsletter.data.dto.ErrorDto;
import com.course.newsletter.data.entity.ArticleCategoryEntity;
import com.course.newsletter.service.ArticleCategoryService;
import com.course.newsletter.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(name = "/article")
@CrossOrigin
public class ArticleController {

    private final ArticleService articleService;

    private final ArticleCategoryService articleCategoryService;

    public ArticleController(ArticleService articleService,
                             ArticleCategoryService articleCategoryService
    ) {
        this.articleService = articleService;
        this.articleCategoryService = articleCategoryService;
    }

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET
    )
    public @ResponseBody ResponseEntity<Object> getArticleList() {
        ArticleListDto articleList = articleService.getArticleList();
        return new ResponseEntity<>(articleList, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST
    )
    public @ResponseBody ResponseEntity<Object> addArticle(@RequestBody @Valid ArticleDto articleDto) {
        Optional<ArticleCategoryEntity> optionalCategory = articleCategoryService.findByName(articleDto.getCategoryName());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ErrorDto("Podana kategoria: '" + articleDto.getCategoryName() + "' nie istnieje!", "categoryName"), HttpStatus.BAD_REQUEST);
        }

        articleService.addArticle(articleDto, optionalCategory.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
