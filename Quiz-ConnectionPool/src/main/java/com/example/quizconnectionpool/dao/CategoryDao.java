package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> findAllCategories();
    Category findCategoryById(int id);
    int createCategory(Category category);
    int updateCategory(Category category);
    int deleteCategory(int id);
}
