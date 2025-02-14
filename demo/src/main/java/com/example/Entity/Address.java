package com.example.Entity;

import jakarta.persistence.*;

@Entity
@Table(name ="address")
public class Address {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name ="id")
    Long id;
    String street;
    String city;



    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
