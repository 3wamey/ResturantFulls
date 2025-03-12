package com.spring.resturantfull.mapper.jwt;

import com.spring.resturantfull.Dtos.jwt.ClientDto;
import com.spring.resturantfull.model.jwt.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper Client_Mapper = Mappers.getMapper(ClientMapper.class);

    Client toEntity(ClientDto clientDto);
    List<Client> toEntityList(List<ClientDto> clientDtoList);

    @Mapping(target ="roles", ignore = true)

    ClientDto toDto(Client client);
    List<ClientDto> toDtoList( List<Client> clientList);
}
