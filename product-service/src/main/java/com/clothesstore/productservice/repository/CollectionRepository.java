package com.clothesstore.productservice.repository;

import com.clothesstore.productservice.model.Collection;
import com.clothesstore.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long >{

}
