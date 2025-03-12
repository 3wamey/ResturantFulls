package com.spring.resturantfull.repository.jwt;

import com.spring.resturantfull.model.jwt.Client;
import com.spring.resturantfull.model.jwt.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByCode(String code);

}
