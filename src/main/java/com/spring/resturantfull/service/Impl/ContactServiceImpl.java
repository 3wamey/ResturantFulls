package com.spring.resturantfull.service.Impl;

import com.spring.resturantfull.Dtos.ContactInfoDto;
import com.spring.resturantfull.mapper.ContactMapper;
import com.spring.resturantfull.model.ContactInfo;
import com.spring.resturantfull.repository.ContactInfoRepo;
import com.spring.resturantfull.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactInfoRepo contactInfoRepo;

    @Override
    public void sendMessage(ContactInfoDto contactInfoDto) {
        ContactInfo contactInfo = ContactMapper.CONTACT_INFO_MAPPER.toEntity(contactInfoDto);
        contactInfoRepo.save(contactInfo);

    }
}
