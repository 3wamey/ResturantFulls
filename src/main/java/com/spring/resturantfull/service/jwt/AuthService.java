package com.spring.resturantfull.service.jwt;

import com.spring.resturantfull.Dtos.jwt.ClientLoginDto;
import com.spring.resturantfull.Dtos.jwt.TokenDto;
import jakarta.transaction.SystemException;

public interface AuthService {
    TokenDto login(ClientLoginDto clientLoginDto) throws SystemException;
}
