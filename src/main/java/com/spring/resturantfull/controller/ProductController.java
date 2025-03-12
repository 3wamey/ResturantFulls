package com.spring.resturantfull.controller;





import com.spring.resturantfull.controller.vm.ProductResponseVM;
import com.spring.resturantfull.service.proudectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private proudectService service;

    @GetMapping("/category/categoryId/{categoryId}/pageNo/{pageNo}/pageSize/{pageSize}")
    ResponseEntity<ProductResponseVM> productAllProducts(@PathVariable("categoryId") Long categoryId, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(service.getProductsByCategoryId(categoryId, pageNo, pageSize));
    }

    @GetMapping("/search/{letters}/pageNo/{pageNo}/pageSize/{pageSize}")
    ResponseEntity<ProductResponseVM> search(@PathVariable("letters") String Letter, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(service.getProductByLetters(Letter, pageNo, pageSize));
    }


    @GetMapping("pageNo/{pageNo}/pageSize/{pageSize}")
    ResponseEntity<ProductResponseVM> productAllProducts(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(service.getProducts(pageNo, pageSize));
    }
}
