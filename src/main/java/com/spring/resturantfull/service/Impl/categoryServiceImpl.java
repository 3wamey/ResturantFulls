package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.mapper.CategoryMapper;
import com.spring.resturantfull.model.Category;
import com.spring.resturantfull.repository.CategoryRepo;
import com.spring.resturantfull.Dtos.categoryDto;
import com.spring.resturantfull.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class categoryServiceImpl implements categoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public List<categoryDto> GetAllCategories() {
        return CategoryMapper.CATEGORY_MAPPER.toDtoList
                (categoryRepo.findAll().stream().toList());
    }

    @Override
    public categoryDto findById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);

        if (category.isEmpty()) {
            throw new RuntimeException("error.invalid.category");
        }
        return CategoryMapper.CATEGORY_MAPPER.toDto(category.get());
    }

}
