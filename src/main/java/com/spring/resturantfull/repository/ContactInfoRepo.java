package com.spring.resturantfull.repository;

import com.spring.resturantfull.model.Chefs;
import com.spring.resturantfull.model.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepo extends JpaRepository<ContactInfo,Long> {

}
