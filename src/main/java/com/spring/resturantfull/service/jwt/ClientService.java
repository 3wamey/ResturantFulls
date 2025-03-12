package com.spring.resturantfull.service.jwt;

import com.spring.resturantfull.Dtos.jwt.ClientDto;
import com.spring.resturantfull.model.jwt.Client;
import jakarta.transaction.SystemException;

public interface ClientService {

    Client getClientbyEmail(String email) throws SystemException;
    Client checkClientExistByToken(String token) throws SystemException;
    void createUserClient (ClientDto clientDto) throws SystemException;
    ClientDto getClientById( Long id);
}
