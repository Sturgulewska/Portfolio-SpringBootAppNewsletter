package com.course.newsletter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDto {
    private String categoryName;
    private String articleName;
    private String articleContent;
    private String dateAdd;
}
