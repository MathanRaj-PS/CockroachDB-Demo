package com.customer.service.repository;

import com.customer.service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author matolaga
 * @version 1.0
 * @project spring-cockroachdb
 * @since 01/11/2021
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
}
