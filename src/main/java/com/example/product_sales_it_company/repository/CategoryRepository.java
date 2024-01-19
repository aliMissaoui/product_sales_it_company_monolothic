package com.example.product_sales_it_company.repository;

import com.example.product_sales_it_company.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Category query methods
    Category findByName(String name);
}
