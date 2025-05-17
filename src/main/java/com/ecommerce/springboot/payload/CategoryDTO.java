package com.ecommerce.springboot.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long categoryId;
    // when validating incoming HTTP payloads with Spring MVC's @Valid, the annotations have to live on the DTO class we're binding to. Spring only looks at whatever we annotate our controller method with.
    @NotBlank(message = "Category name must not be blank")
    @Size(min = 5, message = "Category must contain at least 5 characters")
    private String categoryName;
}
