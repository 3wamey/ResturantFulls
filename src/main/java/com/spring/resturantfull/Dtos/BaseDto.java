package com.spring.resturantfull.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseDto {
    private Long id;

    @NotBlank(message = "error.noSuchLetter")
    private String name;
    private String logoPath;
}
