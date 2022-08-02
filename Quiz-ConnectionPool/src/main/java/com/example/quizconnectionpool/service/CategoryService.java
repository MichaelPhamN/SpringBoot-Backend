package com.example.quizconnectionpool.service;

import com.example.quizconnectionpool.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Integer id);
    int addCategory(Category category);
    int editCategory(Category category);
    int deleteCategory(Integer id);
}
