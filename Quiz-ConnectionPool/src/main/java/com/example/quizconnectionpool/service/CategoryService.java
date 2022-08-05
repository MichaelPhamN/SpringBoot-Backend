package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Integer id);
    int createCategory(Category category);
    int updateCategory(Category category);
    int deleteCategory(Integer id);
}
