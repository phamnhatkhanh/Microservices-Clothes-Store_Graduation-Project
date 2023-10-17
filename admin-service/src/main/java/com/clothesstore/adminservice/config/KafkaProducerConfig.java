package com.clothesstore.adminservice.config;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
//@RequiredArgsConstructor
public class KafkaProducerConfig {


    @Bean
    public NewTopic createTopic(){
        return new NewTopic("demo", 1, (short) 1);
    }

    @Bean
    public Map<String,Object> producerConfig(){
        Map<String,Object> props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.clothesstore.customerservice.dto.*");
        return props;
    }

    @Bean
    public ProducerFactory<String,Object> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String,Object> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

}
//@Component
//@KafkaListener(id = "so65866763", topics = "tp-sale.request")
//public class ConsumerListener {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerListener.class);
//
//    @KafkaHandler
//    @SendTo("tp-sale.reply")
//    public AuthResponseFactory fooListener(AuthRequestFactory authRequestFactory) {
//        System.out.println("In AuthRequestFactoryListener: " + authRequestFactory);
//
//        AuthResponseFactory resObj = new AuthResponseFactory();
//        resObj.setUnique_id("123123");
//
//        return resObj;
//    }
//
//    @KafkaHandler
//    @SendTo("tp-sale.reply")
//    public SaleResponseFactory barListener(SaleRequestFactory saleRequestFactory) {
//        System.out.println("In SaleRequestFactoryListener: " + saleRequestFactory);
//
//        SaleResponseFactory resObj = new SaleResponseFactory();
//        resObj.setUnique_id("123123");
//
//        return resObj;
//    }
//}