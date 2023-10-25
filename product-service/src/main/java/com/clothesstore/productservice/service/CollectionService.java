package com.clothesstore.productservice.service;

import com.clothesstore.productservice.dto.ProductRespone;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectionService {
    List<ProductRespone> findById(Long id);
//    List<ProductRespone> all();

//    List<ProductRespone> findAllById(@RequestParam List<Long> ids);

//    ProductRespone save(ProductRequest productRequest);

//    ProductRespone update(Long id, ProductRequest productRequest);
//
//    void deleteById(Long id);

    
}

