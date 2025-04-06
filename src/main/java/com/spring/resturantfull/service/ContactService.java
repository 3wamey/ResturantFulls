package com.spring.resturantfull.service;


import com.spring.resturantfull.Dtos.ContactInfoDto;

public interface ContactService {

    void sendMessage(ContactInfoDto contactInfoDto);

}
