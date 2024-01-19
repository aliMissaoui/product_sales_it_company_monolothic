package com.example.product_sales_it_company.service;

import com.example.product_sales_it_company.model.Category;
import com.example.product_sales_it_company.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> getCategoryByName(String name) {
        return Optional.ofNullable(categoryRepository.findByName(name));
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Long id, Category updatedCategory) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        existingCategory.ifPresent(category -> {
            category.setName(updatedCategory.getName());
            categoryRepository.save(category);
        });
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
