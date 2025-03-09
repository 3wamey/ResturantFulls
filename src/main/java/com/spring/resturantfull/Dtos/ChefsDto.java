package com.spring.resturantfull.Dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChefsDto {
    private Long id;
    private String name;
    private String logoPath;
    private String specialty;
    private String facebookLink;
    private String twitterLink;
    private String instagramLink;

}
