package com.spring.resturantfull.service.jwt;

import com.spring.resturantfull.Dtos.jwt.ClientDto;
import com.spring.resturantfull.config.jwt.TokenHandler;
import com.spring.resturantfull.mapper.jwt.ClientMapper;
import com.spring.resturantfull.model.jwt.Client;
import com.spring.resturantfull.model.jwt.Role;
import com.spring.resturantfull.repository.jwt.ClientRepo;
import com.spring.resturantfull.repository.jwt.RoleRepo;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepository;
    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Client getClientbyEmail(String email) throws SystemException {

        Client client = clientRepository.findByEmail(email);


        if (client == null) {

            throw new RuntimeException("error.invalid.email");
        }

        return client;
    }

    @Override
    public Client checkClientExistByToken(String token) {
        String email = tokenHandler.getSubject(token);

        if (Objects.isNull(email)) {
            return null;
        }

        return clientRepository.findByEmail(email);
    }

    @Override
    public void createUserClient(ClientDto clientDto) throws SystemException {

        if (clientDto.getId() != null) {
            throw new SystemException("id must be null");
        }
        Client clientExits = clientRepository.findByEmail(clientDto.getEmail());
        if (clientExits != null) {
            throw new RuntimeException("error.clientExist");
        }

        Client client = ClientMapper.Client_Mapper.toEntity(clientDto);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        Role role = roleRepository.findByCode("ROLE_USER");
        if (role == null) {
            throw new SystemException("role not exist");
        }
        List<Role> roles = List.of(role);
        client.setRoles(roles);
        clientRepository.save(client);
    }


    @Override
    public ClientDto getClientById(Long id) {
        Client clients = clientRepository.findById(id).get();
        return ClientMapper.Client_Mapper.toDto(clients);
    }


}
