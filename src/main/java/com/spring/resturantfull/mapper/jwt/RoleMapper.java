package com.spring.resturantfull.mapper.jwt;

import com.spring.resturantfull.Dtos.jwt.RoleDto;
import com.spring.resturantfull.model.jwt.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {


    RoleMapper ROLE_MAPPER = Mappers.getMapper(RoleMapper.class);

    Role toEntity(RoleDto roleDto);

    List<Role> toEntityList(List<RoleDto> roleDtos);

    RoleDto toDto(Role role);
    List<RoleDto> toDtoList(List<Role> roles);
}
