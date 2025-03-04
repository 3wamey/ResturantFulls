package com.spring.resturantfull.service;

import com.spring.resturantfull.service.Dtos.productDto;

import java.util.List;

public interface proudectService {

    List<productDto> GetProductsbyCategoryId(Long categoryId);
    List<productDto> getProductByLetters(String keyword);
    List<productDto> getAllProducts();
}
