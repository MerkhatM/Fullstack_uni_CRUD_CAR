package com.example.eurekaclient.controllers;

import com.example.eurekaclient.models.Category;
import com.example.eurekaclient.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http:://localhost:3000")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }



    @GetMapping("{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }

    @PutMapping("{id}")
    public void editCategory(@RequestBody Category category,@PathVariable Long id) {
        categoryService.editCategory(category,id);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
