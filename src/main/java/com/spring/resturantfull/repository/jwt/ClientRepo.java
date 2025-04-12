package com.spring.resturantfull.repository.jwt;

import com.spring.resturantfull.model.Category;
import com.spring.resturantfull.model.jwt.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {

    Client findByEmail(String email);

}
