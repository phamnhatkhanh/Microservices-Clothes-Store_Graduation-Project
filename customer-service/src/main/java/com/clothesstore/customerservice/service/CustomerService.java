package com.clothesstore.customerservice.service;

import com.clothesstore.customerservice.dto.CustomerRespone;
import com.clothesstore.customerservice.dto.CustomerResquest;
import com.clothesstore.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer findById(Long id);
    List<Customer> all();

    CustomerRespone save(CustomerResquest customerResquest);

    Customer update(Long id, Customer customer);

    void deleteById(Long id);

    
}

