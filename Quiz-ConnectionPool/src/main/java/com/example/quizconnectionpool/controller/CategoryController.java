package com.example.quizconnectionpool.controller;

import com.example.quizconnectionpool.model.Category;
import com.example.quizconnectionpool.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable int id) {
        Category category = categoryService.findCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public int deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }

    @PostMapping("/create")
    public int createCategory(@RequestBody Category category) {
        int executedRow = categoryService.createCategory(category);
        return executedRow;
    }

    @PutMapping("/update")
    public int updateCategory(@RequestBody Category category) {
        int executedRow = categoryService.updateCategory(category);
        return executedRow;
    }
}
