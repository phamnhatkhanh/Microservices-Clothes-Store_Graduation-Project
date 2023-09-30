package com.clothesstore.customerservice.service;

import com.clothesstore.customerservice.dto.CustomerRespone;
import com.clothesstore.customerservice.dto.CustomerResquest;
import com.clothesstore.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerRespone findById(Long id);
    List<CustomerRespone> all();

    CustomerRespone save(CustomerResquest customerResquest);

    CustomerRespone update(Long id, CustomerResquest customerResquest);

    void deleteById(Long id);

    
}

