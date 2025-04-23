package com.spring.resturantfull.service;

import com.spring.resturantfull.Dtos.categoryDto;

import java.util.List;

public interface categoryService {


    List<categoryDto> GetAllCategories();
    categoryDto findById(Long id);
    categoryDto findByName(String name);


    categoryDto addCategory(categoryDto category);
    categoryDto updateCategory(categoryDto category);
    void deleteCategory(Long id);
    boolean existsCategory(String name);

}
