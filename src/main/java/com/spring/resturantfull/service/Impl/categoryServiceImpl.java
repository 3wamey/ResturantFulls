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

    @Override
    public categoryDto findByName(String name) {
        Category category = categoryRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Category not found with name: " + name));
        return  CategoryMapper.CATEGORY_MAPPER.toDto(category);
    }



    @Override
    public categoryDto addCategory(categoryDto dto) {
        Category category = CategoryMapper.CATEGORY_MAPPER.toEntity(dto);
        Category saved = categoryRepo.save(category);
        return CategoryMapper.CATEGORY_MAPPER.toDto(saved);
    }

    @Override
    public categoryDto updateCategory(categoryDto dto) {
        Category existing = categoryRepo.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setName(dto.getName());
        existing.setLogoPath(dto.getLogoPath());
        existing.setFlag(dto.getFlag());

        Category updated = categoryRepo.save(existing);
        return CategoryMapper.CATEGORY_MAPPER.toDto(updated);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepo.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepo.deleteById(id);
    }

    @Override
    public boolean existsCategory(String name) {
        return categoryRepo.existsByName(name);
    }


}
