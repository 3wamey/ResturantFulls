package com.spring.resturantfull.mapper;



import com.spring.resturantfull.model.Category;
import com.spring.resturantfull.Dtos.categoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);


    categoryDto toDto(Category category);
    List<categoryDto> toDtoList(List<Category> categoryList);

    Category toEntity(categoryDto categoryDto);
    List<Category> toEntityList(List<categoryDto> categoryDtoList);

}
