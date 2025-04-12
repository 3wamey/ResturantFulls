package com.spring.resturantfull.service.jwt;

import com.spring.resturantfull.Dtos.jwt.ClientLoginDto;
import com.spring.resturantfull.Dtos.jwt.TokenDto;
import com.spring.resturantfull.config.jwt.TokenHandler;
import com.spring.resturantfull.model.jwt.Client;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto login(ClientLoginDto clientLoginDto) throws SystemException {
        Client client = clientService.getClientbyEmail(clientLoginDto.getEmail());

        if (!passwordEncoder.matches(clientLoginDto.getPassword(),client.getPassword())) {
            throw new BadCredentialsException("error.clientNotExist");
        }

        List<String> roles = client.getRoles().stream().map(role -> role.getCode().substring(5)).collect(Collectors.toList());
        return new TokenDto(tokenHandler.createToken(client), roles);

    }
}
