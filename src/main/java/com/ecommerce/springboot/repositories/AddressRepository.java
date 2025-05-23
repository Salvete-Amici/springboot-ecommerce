package com.ecommerce.springboot.repositories;

import com.ecommerce.springboot.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
