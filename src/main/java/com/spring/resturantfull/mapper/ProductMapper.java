package com.spring.resturantfull.mapper;


import com.spring.resturantfull.model.Product;
import com.spring.resturantfull.service.Dtos.productDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    productDto toDto(Product product);
    List<productDto> toDtoList(List<Product> products);

    Product toEntity(productDto productDto);
    List<Product> toEntityList(List<productDto> productDtos);
}
