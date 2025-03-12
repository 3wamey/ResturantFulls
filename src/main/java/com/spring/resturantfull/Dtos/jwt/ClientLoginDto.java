package com.spring.resturantfull.Dtos.jwt;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientLoginDto {

//    @NotBlank(message = "Email cannot be empty")
//    @Email(message = "Email must be valid")
//    @Pattern(regexp = "^[a-zA-Z0-9]+@gmail\\.com$", message = "Email must be a Gmail address with alphanumeric username")
    private String email;


//    @NotBlank(message = "Password cannot be empty")
//    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;


}
