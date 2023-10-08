package com.clothesstore.adminservice.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface ShopifyService {
    // register webhook
    //

    void syncProductsFromShopify();
    void syncCustomersFromShopify();
    String registerWebhookStore();
    String deleteWebhookStore();


}

