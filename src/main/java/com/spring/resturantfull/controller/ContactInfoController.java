package com.spring.resturantfull.controller;

import com.spring.resturantfull.Dtos.ContactInfoDto;
import com.spring.resturantfull.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contactInfo")
public class ContactInfoController {

    @Autowired
    ContactService contactService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody ContactInfoDto contactInfoDto) {
        contactService.sendMessage(contactInfoDto);
        return ResponseEntity.ok("Message sent successfully");
    }


}
