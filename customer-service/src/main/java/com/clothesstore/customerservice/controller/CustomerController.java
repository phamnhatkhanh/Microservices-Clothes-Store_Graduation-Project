package com.clothesstore.customerservice.controller;

import com.clothesstore.customerservice.dto.CustomerRespone;
import com.clothesstore.customerservice.dto.CustomerResquest;
import com.clothesstore.customerservice.model.Customer;
import com.clothesstore.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/")
    CustomerRespone createCustomer(@RequestBody CustomerResquest customerResquest) {
        return customerService.save(customerResquest);

    }
    @PutMapping("/{id}")
    Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return customerService.findById(id);
//                .map(customer -> {
//                    customer.setName(newCustomer.getName());
//                    customer.setRole(newCustomer.getRole());
//                    albumService.updateAlbum(id, newCustomer);
//                    return customerService.update(customer);
//                })
//                .orElseGet(() -> {
//                    newCustomer.setId(id);
//                    return customerService.save(newCustomer);
//                });
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }

}
