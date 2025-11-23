package com.example.Benchmark.service;


import com.example.Benchmark.dao.CategoryDAO;
import com.example.Benchmark.entity.Category;
import java.util.List;

public class CategoryService {
    private final CategoryDAO dao;

    public CategoryService(CategoryDAO dao) {
        this.dao = dao;
    }

    public Category getCategory(Long id) {
        return dao.findById(id);
    }

    public List<Category> getCategories(int page, int size) {
        return dao.findAll(page, size);
    }

    public void createCategory(Category category) {
        dao.save(category);
    }

    public void updateCategory(Category category) {
        dao.update(category);
    }

    public void deleteCategory(Category category) {
        dao.delete(category);
    }
}
