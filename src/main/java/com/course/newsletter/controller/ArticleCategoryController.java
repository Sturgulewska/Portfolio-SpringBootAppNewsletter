package com.course.newsletter.controller;

import com.course.newsletter.data.dto.EditArticleCategoryDto;
import com.course.newsletter.data.dto.ErrorDto;
import com.course.newsletter.data.entity.ArticleCategoryEntity;
import com.course.newsletter.service.ArticleCategoryService;
import com.course.newsletter.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(name = "/category")
@CrossOrigin
public class ArticleCategoryController {

    private final ArticleCategoryService articleCategoryService;

    public ArticleCategoryController(ArticleService articleService,
                                     ArticleCategoryService articleCategoryService
    ) {
        this.articleCategoryService = articleCategoryService;
    }

    // Bazowy URL: /add/{categoryName}
    // Przykładowy URL: /category/add/Games --> Do zmiennej "categoryName" zostanie przypisany string "Games"
    @RequestMapping(
            value = "/add/{categoryName}",
            method = RequestMethod.POST
    )
    public @ResponseBody ResponseEntity<Object> addCategory(@PathVariable("categoryName") String categoryName) {
        articleCategoryService.addNewCategory(categoryName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "/edit",
            method = RequestMethod.POST
    )
    public @ResponseBody ResponseEntity<Object> editCategory(@RequestBody @Valid EditArticleCategoryDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ErrorDto> errorDtoList = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errorDtoList.add(new ErrorDto(e.getDefaultMessage(), e.getField())));
            return new ResponseEntity<>(errorDtoList, HttpStatus.BAD_REQUEST);
        }

        Long number = dto.getNumber();
        Long largerNumber = number + 1;

        Optional<ArticleCategoryEntity> existingCategory = articleCategoryService.findByName(dto.oldCategoryName);
        if (!existingCategory.isPresent()) {
            return new ResponseEntity<>(new ErrorDto("Podana kategoria: '" + dto.oldCategoryName + "' nie istnieje!", "oldCategoryName"), HttpStatus.BAD_REQUEST);
        }

        articleCategoryService.editCategory(existingCategory.get(), dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
