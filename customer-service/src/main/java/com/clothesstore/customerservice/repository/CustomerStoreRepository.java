package com.clothesstore.customerservice.repository;

import com.clothesstore.customerservice.model.CustomerStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerStoreRepository extends JpaRepository<CustomerStore, Long >{

}
