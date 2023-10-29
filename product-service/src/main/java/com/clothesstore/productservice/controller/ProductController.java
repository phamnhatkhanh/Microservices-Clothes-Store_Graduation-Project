package com.clothesstore.productservice.controller;


import com.clothesstore.productservice.model.Product;
import com.clothesstore.productservice.service.CollectionService;
import com.clothesstore.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    @GetMapping("/")
    ResponseEntity<String> getCustomer () {

        return ResponseEntity.ok("response");
    }

    @Autowired
    private ProductService productService;

    @Autowired
    private CollectionService collectionService;

    @GetMapping("/collections/{id}")
    ResponseEntity<List<Product>> findProductsInCollection (@PathVariable Long id) {
        List<Product> response = productService.findProductsInCollection(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/products/{id}")
    ResponseEntity<Product> findProductid (@PathVariable Long id) {
        Product response = productService.findById(id);
        return ResponseEntity.ok(response);
    }


}
