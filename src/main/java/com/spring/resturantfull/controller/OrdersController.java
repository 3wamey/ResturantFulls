package com.spring.resturantfull.controller;


import com.spring.resturantfull.Dtos.OrdersDto;
import com.spring.resturantfull.controller.vm.OrderDetailsVM;
import com.spring.resturantfull.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    @PostMapping("/saveOrder")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<Map<String, String>> SaveOrder(@RequestBody OrdersDto ordersDto) {
        return ResponseEntity.created(URI.create("/orders/saveOrder")).body(ordersService.saveOrder(ordersDto));
    }

    @GetMapping("/orderDetails/code/{code}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<OrderDetailsVM> getOrderDetails(@PathVariable String code) {
        return ResponseEntity.ok(ordersService.getOrderDetails(code));
    }

    @GetMapping("/allOrderDetails")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    ResponseEntity<List<OrderDetailsVM>> getAllOrderDetails() {
        return ResponseEntity.ok(ordersService.getAllOrderDetails());
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/userOrderDetails")
    ResponseEntity<List<OrderDetailsVM>> getUserOrderDetails() {
        return ResponseEntity.ok(ordersService.getUserOrderDetails());
    }


}
