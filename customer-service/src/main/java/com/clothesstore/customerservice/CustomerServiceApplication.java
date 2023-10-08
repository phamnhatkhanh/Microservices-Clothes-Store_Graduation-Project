package com.clothesstore.customerservice;

import com.clothesstore.customerservice.dto.CustomerDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
//    @Bean
    @KafkaListener(id = "customer-listener", topics = "customer-topic")
    public void receiveMessageFromAdmin(ConsumerRecord<String, CustomerDTO> message) {
        // Process the received message from the Admin service
        // You can perform any necessary business logic here
//        System.out.println("Received message from Admin: " + message);
        System.out.println("Received message from Admin: " + message.value().toString());
    }

}
