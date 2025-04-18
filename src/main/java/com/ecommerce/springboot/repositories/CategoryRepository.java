package com.ecommerce.springboot.repositories;

import com.ecommerce.springboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryName(String categoryName); // JPA will take care of this method implementation based on method naming convention
}
