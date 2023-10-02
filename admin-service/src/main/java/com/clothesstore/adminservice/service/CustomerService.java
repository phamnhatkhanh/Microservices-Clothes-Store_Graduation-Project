package com.clothesstore.adminservice.service;

import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDate;
import java.util.List;

import com.clothesstore.adminservice.model.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    Customer getCustomerById(Long id);
    List<Customer> getCustomers();

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    Customer deleteCustomerById(Long id);

    
}

