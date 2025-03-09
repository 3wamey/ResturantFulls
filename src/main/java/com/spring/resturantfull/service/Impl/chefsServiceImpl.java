package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.Dtos.ChefsDto;
import com.spring.resturantfull.mapper.ChefsMapper;
import com.spring.resturantfull.repository.ChefsRepo;
import com.spring.resturantfull.service.chefsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class chefsServiceImpl implements chefsService {

    @Autowired
    private ChefsRepo chefsRepo;


    @Override
    public List<ChefsDto> getAllChefs() {
        return ChefsMapper.CHEFS_MAPPER.toDto(chefsRepo.findAll());
    }

}
