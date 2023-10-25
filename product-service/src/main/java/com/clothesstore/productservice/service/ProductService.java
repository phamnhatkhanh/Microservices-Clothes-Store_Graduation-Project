package com.clothesstore.productservice.service;

import com.clothesstore.productservice.dto.ProductRequest;
import com.clothesstore.productservice.dto.ProductRespone;
import com.clothesstore.productservice.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface ProductService {
    Product findById(Long id);
    List<Product>  findProductsInCollection(Long collectionId);

//    List<ProductRespone> all();
//
//    List<ProductRespone> findAllById(@RequestParam List<Long> ids);

    Product save(Product productRequest);

//    ProductRespone update(Long id, ProductRequest productRequest);
//
//    void deleteById(Long id);

    
}

