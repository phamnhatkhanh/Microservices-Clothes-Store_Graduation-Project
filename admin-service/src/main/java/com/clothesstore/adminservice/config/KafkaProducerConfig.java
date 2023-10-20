package com.clothesstore.adminservice.config;


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
    public NewTopic createTopic(){
        return new NewTopic("demo", 1, (short) 1);
    }


    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("webhook-customer")
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("webhook-product")
                .build();
    }
    @Bean
    public Map<String,Object> producerConfig(){
        Map<String,Object> props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        props.put(ProducerConfig.GROUP_ID_CONFIG, "ecommerce_group_id");
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
