package com.clothesstore.customerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @KafkaListener( id = "listener1",topics = "sync-customers-shopify", groupId = "group1")
//    public void receiveMessageFromAdmin(ConsumerRecord<String, CustomerDTO> message) {
    public void receiveMessageFromAdmin(String message) {
        // Process the received message from the Admin service
        // You can perform any necessary business logic here
//        System.out.println("Received message from Admin: " + message);
        System.out.println("Received message from Admin: " + message.toString());
    }

}
