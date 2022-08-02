package com.example.quizconnectionpool.service.impl;

import com.example.quizconnectionpool.dao.impl.CategoryDaoImpl;
import com.example.quizconnectionpool.model.Category;
import com.example.quizconnectionpool.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDaoImpl categoryDao;

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAllCategories();
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryDao.findCategoryById(id);
    }

    @Override
    public int addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public int editCategory(Category category) {
        return categoryDao.editCategory(category);
    }

    @Override
    public int deleteCategory(Integer id) {
        return categoryDao.deleteCategory(id);
    }
}
