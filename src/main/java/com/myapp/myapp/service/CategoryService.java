package com.myapp.myapp.service;



import com.myapp.myapp.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    void save(CategoryDto categoryDto);

    public List<CategoryDto> getAll();
    CategoryDto getById(int id);
    void update(CategoryDto courseDto, int id);

    void delete(int id);
}