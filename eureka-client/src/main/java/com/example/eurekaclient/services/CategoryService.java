package com.example.eurekaclient.services;

import com.example.eurekaclient.models.Category;
import com.example.eurekaclient.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll().stream().sorted(Comparator.comparing(Category::getId)).toList();
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void editCategory(Category newCategory,Long id) {
        Category category=categoryRepository.findById(id).orElse(null);
        category.setId(newCategory.getId());
        category.setType(newCategory.getType());
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


}
