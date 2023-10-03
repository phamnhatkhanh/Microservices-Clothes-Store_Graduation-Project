package com.clothesstore.adminservice.service;

import com.clothesstore.adminservice.model.Customer;

import java.util.List;

public interface WebhookService {
    Customer getCustomerById(Long id);
    List<Customer> getCustomers();

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    Customer deleteCustomerById(Long id);

    
}

