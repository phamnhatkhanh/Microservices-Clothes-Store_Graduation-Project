package com.clothesstore.productservice.service;


import com.clothesstore.productservice.model.Product;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ProductService {
    Product findById(Long id);
    List<Product>  findProductsInCollection(Long collectionId);



    Product save(Product productRequest);


    
}

