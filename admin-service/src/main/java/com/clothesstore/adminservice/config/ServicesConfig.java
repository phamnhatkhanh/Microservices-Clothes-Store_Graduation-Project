package com.clothesstore.adminservice.config;


import io.netty.handler.codec.http.HttpMethod;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;

@Configuration
public class ServicesConfig {
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
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
