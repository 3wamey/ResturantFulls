package com.spring.resturantfull.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class productDto  extends BaseDto {
    @NotBlank(message = "error.noSuchLetter")
    private String description;
    private double price;
}
