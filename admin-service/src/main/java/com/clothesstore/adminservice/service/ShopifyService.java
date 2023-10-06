package com.clothesstore.adminservice.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface ShopifyService {
    // register webhook
    //
    String registerWebhookStore();
    String deleteWebhookStore();


}

