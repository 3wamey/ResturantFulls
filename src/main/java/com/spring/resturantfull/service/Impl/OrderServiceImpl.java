package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.Dtos.OrdersDto;
import com.spring.resturantfull.mapper.OrderMapper;
import com.spring.resturantfull.mapper.ProductMapper;
import com.spring.resturantfull.model.Orders;
import com.spring.resturantfull.model.Product;
import com.spring.resturantfull.model.jwt.Client;
import com.spring.resturantfull.repository.OrdersRepo;
import com.spring.resturantfull.service.OrdersService;
import com.spring.resturantfull.service.proudectService;
import com.spring.resturantfull.util.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrdersService {


    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    proudectService proudectService;


    @Override
    public Map<String, String> saveOrder(OrdersDto ordersDto) {
        List<Product> products = ProductMapper.PRODUCT_MAPPER.toEntityList(proudectService.findProductsByIds(ordersDto.getProductsIds()));
        // TO DO  get client from auth context

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        Orders orders = OrderMapper.ORDER_MAPPER.toEntity(ordersDto);
        orders.setClient(client);
        orders.setProducts(products);
        String code = UserCode.extractCode();
        // check on table orders if order has same code
        // re create code and check if recreate still create if code not exist save
        orders.setCode(code);

        orders.setCode(UserCode.extractCode());
        ordersRepo.save(orders);

        Map<String, String> response = new LinkedHashMap<>();
        response.put("code", orders.getCode());
        return response;
    }

}

