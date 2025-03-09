package com.spring.resturantfull.controller;

import com.spring.resturantfull.Dtos.ChefsDto;
import com.spring.resturantfull.service.chefsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chefs")
@CrossOrigin("http://localhost:4200")
public class ChefsController {


    @Autowired
    private chefsService service;

    @GetMapping("/getAll")
    ResponseEntity<List<ChefsDto>> getAllChefs(){
        List<ChefsDto> chefs = service.getAllChefs();
        return ResponseEntity.ok(chefs);
    }


}
