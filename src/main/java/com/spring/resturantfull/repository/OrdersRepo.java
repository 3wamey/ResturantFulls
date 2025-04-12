package com.spring.resturantfull.repository;

import com.spring.resturantfull.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepo extends JpaRepository<Orders,Long> {
    Optional<Orders> findByCode(String code);
    List<Orders> findByClientId(Long id);

}
