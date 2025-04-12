package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.Dtos.ContactInfoDto;
import com.spring.resturantfull.mapper.ContactMapper;
import com.spring.resturantfull.model.ContactInfo;
import com.spring.resturantfull.model.jwt.Client;
import com.spring.resturantfull.repository.ContactInfoRepo;
import com.spring.resturantfull.repository.jwt.ClientRepo;
import com.spring.resturantfull.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactInfoRepo contactInfoRepo;
    @Autowired
    private ClientRepo clientRepo;

    @Override
    public void sendMessage(ContactInfoDto contactInfoDto) {
        ContactInfo contactInfo = ContactMapper.CONTACT_INFO_MAPPER.toEntity(contactInfoDto);
        if (contactInfoDto.getClientId() != null) {
            Optional<Client> clientOpt = clientRepo.findById(contactInfoDto.getClientId());
            clientOpt.ifPresent(contactInfo::setClient); // set client in the entity
        }
        contactInfoRepo.save(contactInfo);

    }
}
