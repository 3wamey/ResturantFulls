package com.spring.resturantfull.controller;


import com.spring.resturantfull.Dtos.OrdersDto;
import com.spring.resturantfull.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    @PostMapping("/saveOrder")
    ResponseEntity<Map<String, String>> saveOrder(@RequestBody OrdersDto ordersDto) {
        return ResponseEntity.created(URI.create("/orders/saveOrder")).body(ordersService.saveOrder(ordersDto));
    }


}
