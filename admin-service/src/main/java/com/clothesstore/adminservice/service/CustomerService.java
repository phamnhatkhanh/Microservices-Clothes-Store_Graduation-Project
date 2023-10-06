package com.clothesstore.adminservice.service;

import com.clothesstore.adminservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    Customer getCustomerById(Long id);
    List<Customer> getCustomers();

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    Customer deleteCustomerById(Long id);

    
}

