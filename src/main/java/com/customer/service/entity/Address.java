package com.customer.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Address {

    @Id
    private UUID id;
    private String address1;
    private String address2;
    private String city;
    private String postcode;
    private String country;
}
