package com.spring.resturantfull.model;


import com.spring.resturantfull.model.jwt.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String totalPrice;
    private String totalQuantity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(
            name = "request_order_product",
            joinColumns = @JoinColumn(name = "request_order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products ;


}

