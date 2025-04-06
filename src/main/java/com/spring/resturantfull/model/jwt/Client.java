package com.spring.resturantfull.model.jwt;

import com.spring.resturantfull.model.ContactInfo;
import com.spring.resturantfull.model.Orders;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Client extends ClientBaseEntity {

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_roles",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<Orders> requestOrders;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    List<ContactInfo> contactInfo;

}
