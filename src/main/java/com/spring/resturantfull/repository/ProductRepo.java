package com.spring.resturantfull.repository;

import com.spring.resturantfull.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {


    List<Product> findAllByCategoryId (Long categoryId);

//SELECT * FROM Product WHERE LOWER(name) LIKE '%' || LOWER(:val) || '%' OR LOWER(description) LIKE '%' || LOWER(:val) || '%'"
//    @Query(value = "select * from Product WHERE  LOWER(name) like '%' || LOWER(:val) || '%' or lower(description) like  '%' || lower(:val) || '%' " , nativeQuery = true)
//    List<Product> getProductByLetters(@Param("val") String letters);


    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> getProductByLetters(@Param("keyword") String keyword);

}
