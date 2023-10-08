package com.clothesstore.adminservice.service;

import com.clothesstore.adminservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WebhookService {
    void sendWebhookToService(String topic);

    
}

