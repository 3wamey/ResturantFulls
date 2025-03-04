package com.spring.resturantfull.controller;


import com.spring.resturantfull.service.Dtos.categoryDto;
import com.spring.resturantfull.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("http://localhost:4200")
public class CategoryController {

    @Autowired
    private categoryService service;


    @GetMapping
    ResponseEntity<List<categoryDto>> categories(){

        return  ResponseEntity.ok(service.GetAllCategories());
    }

}
