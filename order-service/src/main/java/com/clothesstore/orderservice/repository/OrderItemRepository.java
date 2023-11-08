package com.clothesstore.orderservice.repository;

import com.clothesstore.orderservice.model.Order;
import com.clothesstore.orderservice.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
