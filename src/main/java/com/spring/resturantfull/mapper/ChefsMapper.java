package com.spring.resturantfull.mapper;


import com.spring.resturantfull.model.Chefs;
import com.spring.resturantfull.Dtos.ChefsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChefsMapper {


  ChefsMapper  CHEFS_MAPPER = Mappers.getMapper(ChefsMapper.class);

  ChefsDto toDto(Chefs chefs);
  Chefs toEntity(ChefsDto chefsDto);
  List<ChefsDto> toDto(List<Chefs> chefs);
  List<Chefs> toEntity(List<ChefsDto> chefsDtos);



}
