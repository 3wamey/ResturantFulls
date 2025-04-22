package com.spring.resturantfull.service;

import com.spring.resturantfull.Dtos.OrdersDto;
import com.spring.resturantfull.controller.vm.OrderDetailsVM;

import java.util.List;
import java.util.Map;

public interface OrdersService {

    Map<String, String> saveOrder(OrdersDto ordersDto);
    OrderDetailsVM getOrderDetails(String code) throws RuntimeException;
    List<OrderDetailsVM> getAllOrderDetails();
    List<OrderDetailsVM> getUserOrderDetails();
}
