package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.mapper.CategoryMapper;
import com.spring.resturantfull.repository.CategoryRepo;
import com.spring.resturantfull.service.Dtos.categoryDto;
import com.spring.resturantfull.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
