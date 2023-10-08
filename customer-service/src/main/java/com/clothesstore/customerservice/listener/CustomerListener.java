package com.clothesstore.customerservice.listener;

import com.clothesstore.customerservice.dto.CustomerDTO;
import org.springframework.kafka.annotation.KafkaListener;

public class CustomerListener {

    @KafkaListener(id = "customer-listener", topics = "customer-topic")
    public void receiveMessageFromAdmin(CustomerDTO customerDTO) {

        System.out.println("Received message from Admin: " + customerDTO.toString());
    }
}
