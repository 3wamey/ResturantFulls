package com.spring.resturantfull.controller;


import com.spring.resturantfull.Dtos.categoryDto;
import com.spring.resturantfull.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")

public class CategoryController {

    @Autowired
    private categoryService service;


    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<List<categoryDto>> categories(){

        return  ResponseEntity.ok(service.GetAllCategories());
    }





    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<categoryDto> addCategory(@RequestBody categoryDto dto) {
        categoryDto savedCategory = service.addCategory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<categoryDto> updateCategory(@RequestBody categoryDto dto) {
        categoryDto updatedCategory = service.updateCategory(dto);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully.");
    }





}
