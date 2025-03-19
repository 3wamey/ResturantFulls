package com.spring.resturantfull.Dtos.jwt;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
    private Long id;

//    @NotBlank(message = "Name cannot be empty")
//    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

//    @NotBlank(message = "Email cannot be empty")
//    @Email(message = "Email must be valid")
//    @Pattern(regexp = "^[a-zA-Z0-9]+@gmail\\.com$", message = "Email must be a Gmail address with alphanumeric username")
    private String email;

//    @NotBlank(message = "Phone number cannot be empty")
//    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Phone number must be valid")
    private String phoneNumber;

//    @NotBlank(message = "Password cannot be empty")
//    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    private List<RoleDto> roles;
}
