package com.customer.service.controller;

import com.customer.service.entity.Customer;
import com.customer.service.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author matolaga
 * @version 1.0
 * @project spring-cockroachdb
 * @since 01/11/2021
 */

@RestController
@RequestMapping("/customer")
@Tag(name = "Customer Service REST endpoints")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @Operation(summary = "Add new Customer", description = "Add new Customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity createProduct(@RequestBody Customer customer){
        return ResponseEntity
                .status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

    @GetMapping
    @Operation(summary = "Get all customers", description = "Get all customers")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.getAllCustomers());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable final String id){
        customerService.deleteCustomer(UUID.fromString(id));
    }
}
