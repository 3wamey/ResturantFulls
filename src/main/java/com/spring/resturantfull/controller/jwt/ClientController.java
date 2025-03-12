package com.spring.resturantfull.controller.jwt;

import com.spring.resturantfull.Dtos.jwt.ClientDto;
import com.spring.resturantfull.Dtos.jwt.ClientLoginDto;
import com.spring.resturantfull.Dtos.jwt.TokenDto;
import com.spring.resturantfull.service.jwt.AuthService;
import com.spring.resturantfull.service.jwt.ClientService;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ClientService clientService;

    //http://localhost:8080/client/login

    @PostMapping("/login")
    ResponseEntity<TokenDto> login(  @RequestBody ClientLoginDto clientLoginDto) throws SystemException {
        return ResponseEntity.ok(authService.login(clientLoginDto));
    }

   // http://localhost:802/client/create-client

    @PostMapping("/create-client")
    ResponseEntity<Void> createUser( @RequestBody ClientDto clientDto) throws SystemException {
        clientService.createUserClient(clientDto);
        return ResponseEntity.created(URI.create("/client/addClientWithRole")).build();
    }

}
