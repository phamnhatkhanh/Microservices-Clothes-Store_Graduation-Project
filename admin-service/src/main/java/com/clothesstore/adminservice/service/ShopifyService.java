package com.clothesstore.adminservice.service;

import reactor.core.publisher.Mono;

public interface ShopifyService {
    // register webhook
    //
    String registerWebhookStore();
    String deleteWebhookStore();


}

