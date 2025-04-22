package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.Dtos.OrdersDto;
import com.spring.resturantfull.controller.vm.OrderDetailsVM;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrdersService {


    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    proudectService proudectService;

    @Override
    public Map<String, String> saveOrder(OrdersDto ordersDto) {

        List<Product> products = ProductMapper.PRODUCT_MAPPER.toEntityList(proudectService.findProductsByIds(ordersDto.getProductsIds()));
        double totalPrice = products.stream().map(Product::getPrice).reduce(Double::sum).get();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        String code = UserCode.generateCode(ordersRepo.findAll().size(), client.getName());

        Orders orders = OrderMapper.ORDER_MAPPER.toEntity(ordersDto);
        orders.setClient(client);
        orders.setProducts(products);
        orders.setTotalPrice(String.valueOf(totalPrice));
        orders.setTotalQuantity(String.valueOf(products.size()));
        orders.setCode(code);

        ordersRepo.save(orders);

        Map<String, String> response = new LinkedHashMap<>();
        response.put("code", orders.getCode());
        return response;
    }

    @Override
    public OrderDetailsVM getOrderDetails(String code) throws RuntimeException {
        Optional<Orders> orders = ordersRepo.findByCode(code);

        if (orders.isEmpty()) {
            throw new RuntimeException("error.invalid.orderDetails");
        }
        Orders order = orders.get();

        return extractOrderDetailsVM(order);
    }

    @Override
    public List<OrderDetailsVM> getAllOrderDetails() {
        List<Orders> orders = ordersRepo.findAll();
        return orders.stream().map(order -> {
            OrderDetailsVM orderDetailsVM = extractOrderDetailsVM(order);
            orderDetailsVM.setUserName(order.getClient().getName());
            orderDetailsVM.setEmail(order.getClient().getEmail());
            return orderDetailsVM;
        }).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetailsVM> getUserOrderDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Client client = (Client) authentication.getPrincipal();

        List<Orders> orders = ordersRepo.findByClientId(client.getId());

        return orders.stream().map(order -> extractOrderDetailsVM(order)).collect(Collectors.toList());
    }

    private OrderDetailsVM extractOrderDetailsVM(Orders order) {
        OrderDetailsVM orderDetailsVM = new OrderDetailsVM();
        orderDetailsVM.setCode(order.getCode());
        orderDetailsVM.setTotalPrice(order.getTotalPrice());
        orderDetailsVM.setTotalQuantity(order.getTotalQuantity());
        orderDetailsVM.setProductDtos(ProductMapper.PRODUCT_MAPPER.toDtoList(order.getProducts()));
        return orderDetailsVM;
    }


}

