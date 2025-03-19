package com.spring.resturantfull.service;

import com.spring.resturantfull.Dtos.OrdersDto;

import java.util.Map;

public interface OrdersService {

    Map<String, String> saveOrder(OrdersDto ordersDto);
}
