package com.spring.resturantfull.repository;

import com.spring.resturantfull.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    Page<Product> findAllByCategoryId(Long id, Pageable pageable);


    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :val, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :val, '%'))")
    Page<Product> getProductByLetters(@Param("val") String letters, Pageable pageable);



}
