package com.clothesstore.productservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
//
//    @Autowired
//    private  CustomerService customerService;
//
//
//    @GetMapping("/{id}")
//    ResponseEntity<CustomerRespone> getCustomer (@PathVariable Long id) {
//        CustomerRespone response = customerService.findById(id);
//        if (response.getErrorMessage() != null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//        return ResponseEntity.ok(response);
//    }
//    @GetMapping("/byIds")
//    List<CustomerRespone> getListCustomers(@RequestParam List<Long> ids) {
//        return customerService.findAllById(ids);
//    }
//    @GetMapping("/")
//    List<CustomerRespone> getListCustomers() {
//        return customerService.all();
//
//    }
//    @PostMapping("/")
//    CustomerRespone createCustomer(@RequestBody CustomerRequest customerRequest) {
//        return customerService.save(customerRequest);
//
//    }
//    @PutMapping("/test/{id}")
//    CustomerRespone updateCustomerTest(@RequestBody CustomerRequest customerRequest, @PathVariable Long id) {
//
//        return customerService.update(id, customerRequest);
//
//    }
//
//    @PutMapping("/{id}")
//    CustomerRespone updateCustomer(@RequestBody CustomerRequest customerRequest, @PathVariable Long id) {
//
//        return customerService.update(id, customerRequest);
////                .map(customer -> {
////                    customer.setName(newCustomer.getName());
////                    customer.setRole(newCustomer.getRole());
////                    albumService.updateAlbum(id, newCustomer);
////                    return customerService.update(customer);
////                })
////                .orElseGet(() -> {
////                    newCustomer.setId(id);
////                    return customerService.save(newCustomer);
////                });
//    }
//
//    @DeleteMapping("/{id}")
//    void deleteById(@PathVariable Long id) {
//        customerService.deleteById(id);
//    }

}
