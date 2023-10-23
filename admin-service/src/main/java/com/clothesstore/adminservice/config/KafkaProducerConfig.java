package com.clothesstore.adminservice.config;


import com.clothesstore.adminservice.dto.respone.ProductDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.*;

@Configuration
//@RequiredArgsConstructor
public class KafkaProducerConfig {


    @Bean
    public NewTopic topic() {
        NewTopic newTopic = new NewTopic("sync-product-shopify", 1, (short) 1);
        Map<String, String> configs = new HashMap<>();
        configs.put("max.message.bytes", "20971520");
        newTopic.configs(configs);
        return newTopic;
    }

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("sync-customer-shopify")
                .build();
    }

    @Bean
    public ProducerFactory<String, ProductDTO> productDTOProducerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props);
    }

    /**
     * Kafka template will be used to publish messages to kafka
     * @return : Configured kafka template to send cash transactions
     */
    @Bean
    public KafkaTemplate<String, ProductDTO> kafkaProductDTOTemplate() {
        return new KafkaTemplate<>(productDTOProducerFactory());
    }


    @Bean
    public Map<String,Object> producerConfig(){
        Map<String,Object> props=new HashMap<>();
        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, 10485880);

//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 30000000);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;
    }

    @Bean
    public ProducerFactory<String,String> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

}
