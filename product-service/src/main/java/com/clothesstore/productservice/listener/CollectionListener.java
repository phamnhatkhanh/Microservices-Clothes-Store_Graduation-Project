package com.clothesstore.productservice.listener;

import com.clothesstore.productservice.dto.CollectionDTO;
import com.clothesstore.productservice.dto.ProductDTO;
import com.clothesstore.productservice.model.Collection;
import com.clothesstore.productservice.model.Product;
import com.clothesstore.productservice.repository.CollectionRepository;
import com.clothesstore.productservice.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CollectionListener {

    @Autowired
    CollectionRepository collectionRepository;
    @Autowired
    ModelMapper modelMapper;
    @KafkaListener(topics = "sync-collects-shopify",groupId = "ecommerce_group_id")
    public void receiveMessageFromAdmin(String productDtoJson) {
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            CollectionDTO collectionDTO = objectMapper.readValue(productDtoJson, CollectionDTO.class);
            Collection dataProduct = modelMapper.map(collectionDTO,Collection.class);
            collectionRepository.save(dataProduct);
            System.out.println("Received Collection Id:  " + collectionDTO.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
