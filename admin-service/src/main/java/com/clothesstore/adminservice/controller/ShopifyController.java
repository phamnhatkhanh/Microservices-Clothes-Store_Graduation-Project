package com.clothesstore.adminservice.controller;

import com.clothesstore.adminservice.service.ShopifyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/shopify")
public class ShopifyController
{

    @Autowired
    private ShopifyService shopifyService;

    @GetMapping("/register-webhook")
    public String registerWebhook(){
        return  shopifyService.registerWebhookStore();

    }
    @DeleteMapping("/delete-webhook")
    public String deleteWebhook(){
        return  shopifyService.deleteWebhookStore();

    }






    // register Webhook
    // get Topic
    //


}
