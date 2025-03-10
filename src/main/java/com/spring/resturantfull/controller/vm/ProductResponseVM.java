package com.spring.resturantfull.controller.vm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.resturantfull.Dtos.productDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseVM {

    @JsonProperty("products")
    private List<productDto> productDtos;

    @JsonProperty("totalProductSize")
    private Long totalProductSize;
}