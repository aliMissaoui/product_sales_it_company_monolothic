package com.example.product_sales_it_company.repository;

import com.example.product_sales_it_company.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Product query methods
    List<Product> findByCategoryName(String categoryName);
}
