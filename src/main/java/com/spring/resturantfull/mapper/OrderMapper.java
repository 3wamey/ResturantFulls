package com.spring.resturantfull.mapper;

import com.spring.resturantfull.Dtos.OrdersDto;
import com.spring.resturantfull.model.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    Orders toEntity(OrdersDto ordersDto);
    List<Orders> toEntity(List<OrdersDto> ordersDto);

    OrdersDto toDto(Orders orders);
    List<OrdersDto> toDto(List<Orders> orders);

}
