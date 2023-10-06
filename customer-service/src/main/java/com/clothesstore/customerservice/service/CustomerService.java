package com.clothesstore.customerservice.service;

import com.clothesstore.customerservice.dto.CustomerRespone;
import com.clothesstore.customerservice.dto.CustomerRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface CustomerService {
    CustomerRespone findById(Long id);
    List<CustomerRespone> all();

    List<CustomerRespone> findAllById(@RequestParam List<Long> ids);

    CustomerRespone save(CustomerRequest customerRequest);

    CustomerRespone update(Long id, CustomerRequest customerRequest);

    void deleteById(Long id);

    
}

