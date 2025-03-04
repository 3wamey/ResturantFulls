package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.mapper.ProductMapper;
import com.spring.resturantfull.model.Product;
import com.spring.resturantfull.repository.ProductRepo;
import com.spring.resturantfull.service.Dtos.productDto;
import com.spring.resturantfull.service.proudectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productServiceImpl implements proudectService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<productDto> GetProductsbyCategoryId(Long categoryId) {
        return ProductMapper.PRODUCT_MAPPER
                        .toDtoList(productRepo.findAllByCategoryId(categoryId));
    }

    @Override
    public List<productDto> getProductByLetters(String keyword) {
        List<Product> products = productRepo.getProductByLetters(keyword);
        if (products.isEmpty()) {
            throw  new RuntimeException("error.noSuchLetter");
        }
        return ProductMapper.PRODUCT_MAPPER.toDtoList(products);
    }

    @Override
    public List<productDto> getAllProducts() {
        return ProductMapper.PRODUCT_MAPPER.toDtoList(productRepo.findAll());
    }

}
