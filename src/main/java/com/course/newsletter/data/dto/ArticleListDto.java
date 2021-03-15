package com.course.newsletter.data.dto;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleListDto {
    private List<ArticleDto> articleList = new ArrayList<>();
}
