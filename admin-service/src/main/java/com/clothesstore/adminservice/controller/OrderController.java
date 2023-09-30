package com.clothesstore.adminservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/admin/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final WebClient.Builder webClientBuilder;
    @Value("${shopify.access.token}")
    private String shopifyAcesstoken;

    @GetMapping("/khanh")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> isInStock() throws JsonProcessingException {
        log.info("Start prepare {}");

        Object entities = webClientBuilder.build().get()
                .uri("https://khanhpham530112313.myshopify.com/admin/api/2023-04/product.json",
                        uriBuilder -> uriBuilder.queryParam("ids", "5638817939665").build())
                .headers(
                        httpHeaders -> {
                            httpHeaders.set("X-Shopify-Access-Token", shopifyAcesstoken);

                        })

                .retrieve()
                .bodyToMono(Object.class)
                .block();

//
//        HttpHeaders responseHeaders = entities.getHeaders();
//
//
//        ObjectMapper ow = new ObjectMapper();
//        String json = ow.writeValueAsString(responseHeaders);
//
//
//        log.info(json);

        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

}
