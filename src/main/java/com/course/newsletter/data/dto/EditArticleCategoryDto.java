package com.course.newsletter.data.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EditArticleCategoryDto {

    @NotBlank(message = "Nazwa istniejącej kategorii nie może być pusta!")
    public String oldCategoryName;

    @NotBlank(message = "Nazwa na jaką zmienić kategorię nie może być pusta!")
    public String newCategoryName;

    @NotNull(message = "Cyfra nie może być nullem!")
    @Min(value = 1, message = "Cyfra nie może być mniejsza od 1!")
    @Max(value = 20, message = "Cyfra nie może być większa niż 20!")
    public Long number;
}
