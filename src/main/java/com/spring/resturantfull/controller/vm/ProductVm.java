package com.spring.resturantfull.controller.vm;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductVm {
    private String categoryName;
    private String description;
    private double price;
    private String logoPath;
    private String name;


}
