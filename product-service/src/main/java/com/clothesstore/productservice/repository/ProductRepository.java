package com.clothesstore.productservice.repository;

import com.clothesstore.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long >{
    @Query(value = "SELECT p.* FROM Product p " +
            "INNER JOIN Collection c ON p.id = c.product_id " +
            "WHERE c.collection_id = :collectionId", nativeQuery = true)
    List<Product> findProductsInCollection(Long collectionId);

}
