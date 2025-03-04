package com.spring.resturantfull.controller;




import com.spring.resturantfull.service.Dtos.productDto;
import com.spring.resturantfull.service.proudectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
@CrossOrigin("http://localhost:4200")
public class ProductController {

    @Autowired
    private proudectService service;

    @GetMapping("/category/categoryId/{categoryId}")
    ResponseEntity<List<productDto>> productAllProducts(@PathVariable("categoryId") Long categoryId) {
        return ResponseEntity.ok(service.GetProductsbyCategoryId(categoryId));
    }



    @GetMapping("/search/{keyword}")
    ResponseEntity<List<productDto>> search(@PathVariable("keyword") String keyword) {
        return ResponseEntity.ok(service.getProductByLetters(keyword));
    }


    @GetMapping
    ResponseEntity<List<productDto>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

}
