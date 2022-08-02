package com.example.quizconnectionpool.dao;

import com.example.quizconnectionpool.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> findAllCategories();
    Category findCategoryById(Integer id);
    int addCategory(Category category);
    int editCategory(Category category);
    int deleteCategory(Integer id);
}
