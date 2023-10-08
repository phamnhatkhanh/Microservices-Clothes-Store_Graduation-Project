package com.clothesstore.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @KafkaListener(id = "listener2", topics = "customer-topic",groupId = "ecommerce_group_id")
//    public void receiveMessageFromAdmin(ConsumerRecord<String, CustomerDTO> message) {
    public void receiveMessageFromAdmin(String message) {
        // Process the received message from the Admin service
        // You can perform any necessary business logic here
//        System.out.println("Received message from Admin: " + message);
        System.out.println("Received message from Admin: " + message.toString());
    }
}
