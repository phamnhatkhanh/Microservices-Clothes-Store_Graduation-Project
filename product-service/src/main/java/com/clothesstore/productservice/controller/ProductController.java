package com.clothesstore.productservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    @GetMapping("/")
    ResponseEntity<String> getCustomer () {

        return ResponseEntity.ok("response");
    }
//
//    @Autowired
//    private  ProductService customerService;
//
//
//    @GetMapping("/{id}")
//    ResponseEntity<ProductRespone> getCustomer (@PathVariable Long id) {
//        ProductRespone response = customerService.findById(id);
//        if (response.getErrorMessage() != null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
//        }
//        return ResponseEntity.ok(response);
//    }
//    @GetMapping("/byIds")
//    List<ProductRespone> getListCustomers(@RequestParam List<Long> ids) {
//        return customerService.findAllById(ids);
//    }
//    @GetMapping("/")
//    List<ProductRespone> getListCustomers() {
//        return customerService.all();
//
//    }
//    @PostMapping("/")
//    ProductRespone createCustomer(@RequestBody ProductRequest customerRequest) {
//        return customerService.save(customerRequest);
//
//    }
//    @PutMapping("/test/{id}")
//    ProductRespone updateCustomerTest(@RequestBody ProductRequest customerRequest, @PathVariable Long id) {
//
//        return customerService.update(id, customerRequest);
//
//    }
//
//    @PutMapping("/{id}")
//    ProductRespone updateCustomer(@RequestBody ProductRequest customerRequest, @PathVariable Long id) {
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
