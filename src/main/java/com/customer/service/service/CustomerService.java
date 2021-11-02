package com.customer.service.service;

import com.customer.service.entity.Customer;
import com.customer.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * @author matolaga
 * @version 1.0
 * @project spring-cockroachdb
 * @since 01/11/2021
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        UUID uuid = UUID.randomUUID();
        customer.setId(uuid);
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public void deleteCustomer(UUID id) {
        customerRepository.findById(id).ifPresent(customerRepository::delete);
    }
}
