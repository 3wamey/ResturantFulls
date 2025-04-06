package com.spring.resturantfull.model;


import com.spring.resturantfull.model.jwt.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String subject;
    @Column(length = 1000)
    private String message;

    @ManyToOne()
    @JoinColumn(name ="Client_id")
    private Client client;

}
