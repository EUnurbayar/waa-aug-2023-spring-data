package com.myapp.myapp.controller;


import com.myapp.myapp.dto.CategoryDto;
import com.myapp.myapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public void save(@RequestBody CategoryDto categoryDto){
        categoryService.save(categoryDto);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll(){
        List<CategoryDto> categoryDtoList = categoryService.getAll();
        return ResponseEntity.ok(categoryDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable int id){
        CategoryDto categoryDto = categoryService.getById(id);
        if(categoryDto != null) return ResponseEntity.ok(categoryDto);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CategoryDto categoryDto){
        categoryService.update(categoryDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }


};