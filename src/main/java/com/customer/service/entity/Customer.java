package com.customer.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL,
    fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "companyId", referencedColumnName = "id")
    private List<Address> address;

}
