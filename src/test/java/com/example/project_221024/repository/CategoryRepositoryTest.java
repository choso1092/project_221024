package com.example.project_221024.repository;

import com.example.project_221024.Project221024ApplicationTests;
import com.example.project_221024.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


@SpringBootTest
public class CategoryRepositoryTest extends Project221024ApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = new Category();
        category.setType("test");
        category.setTitle("student");
        category.setCreatedAt(LocalDateTime.now());
        category.setCreatedBy("chisoo");

        categoryRepository.save(category);
    }
}
