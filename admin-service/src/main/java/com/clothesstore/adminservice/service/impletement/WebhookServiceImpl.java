package com.clothesstore.adminservice.service.impletement;

import com.clothesstore.adminservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebhookServiceImpl {
    @Value("${shopify.domain.store}")
    private String shopifyDomain;
    @Value("${shopify.access.token}")
    private String shopifyAcesstoken;

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final WebClient.Builder webClientBuilder;


    



}
