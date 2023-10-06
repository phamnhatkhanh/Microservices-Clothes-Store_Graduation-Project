package com.clothesstore.customerservice.repository;

import com.clothesstore.customerservice.model.Address;
import com.clothesstore.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long >{

}
