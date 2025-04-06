package com.spring.resturantfull.mapper;

import com.spring.resturantfull.Dtos.ContactInfoDto;
import com.spring.resturantfull.model.ContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMapper {

    ContactMapper CONTACT_INFO_MAPPER = Mappers.getMapper(ContactMapper.class);

    @Mapping(target = "client", ignore = true)
    ContactInfo toEntity(ContactInfoDto contactInfoDto);

    List<ContactInfo> toEntity(List<ContactInfoDto> contactInfoDtos);

    @Mapping(source = "client.id", target = "clientId")
    ContactInfoDto toDto(ContactInfo contactInfo);

    List<ContactInfoDto> toDto(List<ContactInfo> contactInfos);
}
