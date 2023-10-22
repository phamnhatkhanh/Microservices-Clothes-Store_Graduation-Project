package com.clothesstore.productservice.config;



import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    @Bean
    public Map<String, Object> consumerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, String.class);
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
//        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
//        props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
//        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "20971520");
//        props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "20971520");

//        props.put(JsonDeserializer.TYPE_MAPPINGS, "product:com.clothesstore.customerservice.dto.ProductDTO, customer:com.clothesstore.customerservice.dto.CustomerDTO");
        return props;
    }

    @Bean
    public ConsumerFactory<String,Object> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}

