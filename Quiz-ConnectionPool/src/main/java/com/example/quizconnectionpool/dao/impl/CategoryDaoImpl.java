package com.example.quizconnectionpool.dao.impl;

import com.example.quizconnectionpool.config.DBConfig;
import com.example.quizconnectionpool.dao.CategoryDao;
import com.example.quizconnectionpool.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private DBConfig config;
    private static final Logger logger = LogManager.getLogger(CategoryDaoImpl.class);
    @Override
    public List<Category> findAllCategories() {
        List<Category> categories = new ArrayList<>();
        try {
            String sql = "SELECT cat_id, category_name FROM category";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCatId(resultSet.getInt("cat_id"));
                category.setCatName(resultSet.getString("category_name"));
                logger.debug("Category: ({})", category);
                categories.add(category);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findCategoryById(int id) {
        Category category = null;
        try {
            String sql = "SELECT cat_id, category_name FROM category WHERE category.cat_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category = new Category();
                category.setCatId(resultSet.getInt("cat_id"));
                category.setCatName(resultSet.getString("category_name"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public int createCategory(Category category) {
        int executedRow = 0;
        try {
            String sql = "INSERT INTO category(category_name) VALUES (?)";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, category.getCatName());
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public int updateCategory(Category category) {
        int executedRow = 0;
        try {
            String sql = "UPDATE category SET category.category_name = ? WHERE category.cat_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, category.getCatName());
            preparedStatement.setInt(2, category.getCatId());
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }

    @Override
    public int deleteCategory(int id) {
        int executedRow = 0;
        try {
            String sql = "DELETE FROM category WHERE category.cat_id = ?";
            PreparedStatement preparedStatement = config.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            executedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return executedRow;
    }
}
