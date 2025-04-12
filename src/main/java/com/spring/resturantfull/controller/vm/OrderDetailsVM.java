package com.spring.resturantfull.controller.vm;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.resturantfull.Dtos.productDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsVM {

    private String code;

    @JsonProperty("products")
    private List<productDto> productDtos;

    private String totalPrice;

    private String totalQuantity;

}
