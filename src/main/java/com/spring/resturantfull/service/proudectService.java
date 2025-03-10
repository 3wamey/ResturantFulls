package com.spring.resturantfull.service;

import com.spring.resturantfull.Dtos.productDto;
import com.spring.resturantfull.controller.vm.ProductResponseVM;

import java.util.List;

public interface proudectService {

    ProductResponseVM getProductsByCategoryId(Long categoryId, Integer pageNo, Integer pageSize);

    ProductResponseVM getProductByLetters(String letter, Integer pageNo, Integer pageSize);



    ProductResponseVM getProducts(Integer pageNo, Integer pageSize);





//    List<productDto> GetProductsbyCategoryId(Long categoryId);
//    List<productDto> getProductByLetters(String keyword);
//    List<productDto> getAllProducts();


}
