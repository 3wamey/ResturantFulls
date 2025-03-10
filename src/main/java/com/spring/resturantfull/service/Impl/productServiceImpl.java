package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.controller.vm.ProductResponseVM;
import com.spring.resturantfull.mapper.ProductMapper;
import com.spring.resturantfull.model.Product;
import com.spring.resturantfull.repository.ProductRepo;
import com.spring.resturantfull.Dtos.productDto;
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
    public ProductResponseVM getProductsByCategoryId(Long categoryId, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> productPage = productRepo.findAllByCategoryId(categoryId, pageable);

        return new ProductResponseVM(
                ProductMapper.PRODUCT_MAPPER.toDtoList(productPage.getContent()),
                productPage.getTotalElements()
        );
    }





    @Override
        public ProductResponseVM getProductByLetters(String letter, Integer pageNo, Integer pageSize) { //
            Pageable pageable = PageRequest.of(pageNo, pageSize);
            Page<Product> productPage = productRepo.getProductByLetters(letter, pageable);
            List<Product> products = productPage.getContent();

            if (products.isEmpty()) {
                throw new RuntimeException("error.noSuchLetter");
            }

            return new ProductResponseVM(
                    ProductMapper.PRODUCT_MAPPER.toDtoList(products),
                    productPage.getTotalElements()
            );
    }



    @Override
    public ProductResponseVM getProducts(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Product> productPage = productRepo.findAll(pageable);

        return new ProductResponseVM(
                ProductMapper.PRODUCT_MAPPER.toDtoList(productPage.getContent()),
                productPage.getTotalElements()
        );
    }
}