package com.clothesstore.adminservice.config;


import io.netty.handler.codec.http.HttpMethod;
import org.hibernate.mapping.Map;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@Configuration
public class ServicesConfig {
    @Bean
    public WebClient.Builder webClientBuilder() {
        final int size = 10*1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs
                        .defaultCodecs()
                        .maxInMemorySize(size))
                .build();
        return WebClient.builder().exchangeStrategies(strategies);
    }

//    @Bean
//    public WebClient webClient() {
//
//        return WebClient.builder()
//
//    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

//    @Bean
//    public Environment environment() {
//        return new Environment();
//    }
//    @Configuration
//    public class WebClientConfig {
//
//        @Bean
//        @LoadBalanced
//        public WebClient.Builder webClientBuilder() {
//            return WebClient.builder();
//        }
//    }

}
