package com.spring.resturantfull.controller;





import com.spring.resturantfull.Dtos.productDto;
import com.spring.resturantfull.controller.vm.ProductResponseVM;
import com.spring.resturantfull.service.proudectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private proudectService service;

    @GetMapping("/category/categoryId/{categoryId}/pageNo/{pageNo}/pageSize/{pageSize}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<ProductResponseVM> productAllProducts(@PathVariable("categoryId") Long categoryId, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(service.getProductsByCategoryId(categoryId, pageNo, pageSize));
    }

    @GetMapping("/search/{letters}/pageNo/{pageNo}/pageSize/{pageSize}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<ProductResponseVM> search(@PathVariable("letters") String Letter, @PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(service.getProductByLetters(Letter, pageNo, pageSize));
    }


    @GetMapping("pageNo/{pageNo}/pageSize/{pageSize}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<ProductResponseVM> productAllProducts(@PathVariable Integer pageNo, @PathVariable Integer pageSize) {
        return ResponseEntity.ok(service.getProducts(pageNo, pageSize));
    }

    @PostMapping("/product/addProduct")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<productDto> addProduct(@RequestBody productDto   product) {
        return ResponseEntity.ok(service.addProduct(product));
    }


}
