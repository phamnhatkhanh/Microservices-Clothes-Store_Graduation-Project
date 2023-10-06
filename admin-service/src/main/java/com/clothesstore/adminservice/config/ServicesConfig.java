package com.clothesstore.adminservice.config;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
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
